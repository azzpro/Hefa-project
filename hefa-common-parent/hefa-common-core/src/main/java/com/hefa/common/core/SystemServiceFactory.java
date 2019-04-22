package com.hefa.common.core;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemServiceFactory {
    private final static Logger logger = LoggerFactory.getLogger(SystemServiceFactory.class);

    public static <T> T getService(String type, Class<T> classType) {
        if (type == null || classType == null) {
            return null;
        }
        T service = null;
        if (classType.isInterface()) {
            ServiceLoader serviceLoader = ServiceLoader.load(classType);
            Iterator<T> it = serviceLoader.iterator();
            while (it.hasNext()) {
                service = it.next();
                if (service instanceof BaseService) {
                    String serviceType = ((BaseService) service).getType();
                    if (serviceType != null && serviceType.equalsIgnoreCase(type)) {
                        logger.trace("get service bean by spi:" + type + " for " + classType);
                        return service;
                    }
                }
            }
        }
        try {
            service = (T) Class.forName(type).newInstance();
            logger.trace("get service bean by newInstance:" + type + " for " + classType);
            return service;
        } catch (Exception e) {
        }
        try {
            service = BeanHoldFactory.getApplicationContext().getBean(type, classType);
            logger.trace("get service bean by spring:" + type + " for " + classType);
            return service;
        } catch (Exception e) {
        }
        throw new RuntimeException();
    }
}
