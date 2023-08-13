package com.zsx.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBeanConfig {


    @Bean(name = "testBean2")
    public TestBean init() {
        return new TestBean();
    }


}
