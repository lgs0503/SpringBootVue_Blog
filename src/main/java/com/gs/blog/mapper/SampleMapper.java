package com.gs.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    String selectSample() throws Exception;
}
