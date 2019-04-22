package com.hefa.sequence.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * <P>TODO</P>
 * @version 1.0
 * @author 刘建麟  2018年10月24日 上午11:35:03
 */
public class SequenceConfig {
	 private String id;
	    private String type;
	    private Map<String, Object> args;
	    private SequenceConfig[] segmentConfigs;
	    private Map<String, Object> initArgs = new HashMap<>();

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public Map<String, Object> getArgs() {
	        return args;
	    }

	    public void setArgs(Map<String, Object> args) {
	        this.args = args;
	    }

	    public SequenceConfig[] getSegmentConfigs() {
	        return segmentConfigs;
	    }

	    public void setSegmentConfigs(SequenceConfig[] segmentConfigs) {
	        this.segmentConfigs = segmentConfigs;
	    }

	    public void addInitArg(String name, Object value) {
	        initArgs.put(name, value);
	    }

	    public Object getInitArg(String name) {
	        return initArgs.get(name);
	    }

	    public Map<String, Object> getInitArgs() {
	        return initArgs;
	    }

	    public void setInitArgs(Map<String, Object> initArgs) {
	        this.initArgs = initArgs;
	    }

	    @Override
	    public String toString() {
	        return "DbSequenceConfig{" +
	                "id='" + id + '\'' +
	                ", type='" + type + '\'' +
	                ", args=" + args +
	                ", segmentConfigs=" + Arrays.toString(segmentConfigs) +
	                '}';
	    }
    
    

}
