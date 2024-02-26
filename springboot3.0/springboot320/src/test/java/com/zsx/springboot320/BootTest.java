package com.zsx.springboot320;

import com.zsx.springboot320.config.CustomConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @date 2024/2/26
 */
@SpringBootTest(classes = {Springboot320Application.class})
public class BootTest {


    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CustomConfig customConfig;

    @Test
    void t1() {
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }



    @Test
    void t2() {
        System.out.println(8899);
        System.out.println(8899);
        System.out.println(8899);
        System.out.println(customConfig.getName());
        System.out.println(customConfig.getUrl());
    }

}
