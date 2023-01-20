package com.gs.blog.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleMapperTest {

    @Autowired
    SampleMapper sampleMapper;

    @Test
    @DisplayName("Mapper 테스트")
    void selectSample() throws Exception{
        String currDate = sampleMapper.selectSample();
        System.out.println("currDate : " + currDate);
    }
}