package com.hefa.sequence.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.hefa.sequence.base.service.GenerateSequenceService;
import com.hefa.sequence.base.service.SystemSequenceService;

@Configuration
@EnableConfigurationProperties(SystemSequenceConfig.class)
@ConditionalOnProperty(name = "available", prefix = "hefa.sequence", havingValue = "true")
@AutoConfigureBefore(DataSourceTransactionManager.class)
public class SequenceAutoConfiguration implements ApplicationContextAware{
    private Logger logger = LoggerFactory.getLogger(SequenceAutoConfiguration.class);

    @Autowired
    private SystemSequenceConfig sequenceConfig;
    
    public static BeanDefinitionRegistry registry;
   
    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    private ApplicationContext applicationContext;


    @Bean
    public Object generateSequenceBeans(@Autowired DataSourceTransactionManager transactionManager) throws Exception {
        logger.info("Invoke Method postProcessBeanDefinitionRegistry");
        if (sequenceConfig == null) {
            logger.warn("systemSequenceConfig is not found, if you want use sequence component, you must make it, now we skip it for you");
            return new Object();
        }
        List<SequenceConfig> sequenceConfigs = sequenceConfig.getSequenceConfigs();
        if (sequenceConfigs != null) {
            for (SequenceConfig sequenceConfig : sequenceConfigs) {
                Object sequenceImpl = GenerateSequenceService.getSequence(sequenceConfig);
                SystemSequenceService systemSequence = registerSequenceBean(registry, sequenceConfig.getId(), sequenceImpl.getClass());
                try {
                    sequenceConfig.addInitArg("transactionManager", transactionManager);
                    systemSequence.init(sequenceConfig);
                } catch (Exception e) {
                    throw new Exception("error occurs when create sequence: " + sequenceConfig, e);
                }
            }
        }
        return new Object();
    }

    private SystemSequenceService registerSequenceBean(@Autowired BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);

        ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
        abd.setScope(scopeMetadata.getScopeName());
        // 可以自动生成name
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, registry));

        AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);

        return (SystemSequenceService) applicationContext.getBean(beanName);
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}

