package com.example.springboot270;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @date 2022/8/15
 */
@Component
public class InitConfig implements InitializingBean {

    @Value("${test.username}")
    private String username;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(8899);
        System.out.println(username);
    }
}
