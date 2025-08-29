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
    public TestService newTestService() {
        return testService;
    }

    /**
     * org.springframework.beans.factory.NoUniqueBeanDefinitionException:
     * No qualifying bean of type 'com.springboot335.springboot335.service.TestService' available:
     * expected single matching bean but found 2: testServiceImpl,newTestService
     */

    /*
    TestService testService = applicationContext.getBean("newTestService", TestService.class);
    需要指定beanName，可以正常调用
     */

}
