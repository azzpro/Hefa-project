package com.hefa.sequence.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SequenceMapper {
	
	String getSequenceNo(String type);
}
