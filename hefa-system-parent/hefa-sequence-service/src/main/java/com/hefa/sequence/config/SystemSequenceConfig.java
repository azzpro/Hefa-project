package com.hefa.sequence.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月24日 下午3:13:27
 */
@ConfigurationProperties(prefix = "hefa.sequence")
public class SystemSequenceConfig {
    private List<SequenceConfig> sequenceConfigs = new ArrayList<>();

    public List<SequenceConfig> getSequenceConfigs() {
        return sequenceConfigs;
    }

    public void setSequenceConfigs(List<SequenceConfig> sequenceConfigs) {
        this.sequenceConfigs = sequenceConfigs;
    }
}
