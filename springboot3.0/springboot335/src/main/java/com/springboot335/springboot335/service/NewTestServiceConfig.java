package com.springboot335.springboot335.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class NewTestServiceConfig {

    @Autowired
    private TestService testService;


    @Bean("newTestService")
    @Scope(value = "prototype")
    public TestService newTestService() {
        return testService;
    }

}
