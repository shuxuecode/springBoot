package com.zsx.springboot310;

import com.zsx.springboot310.config.DemoConfig;
import com.zsx.springboot310.controller.DemoController;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.ApplicationContextTestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
class Springboot310ApplicationTests {

    @Autowired
    DemoConfig demoConfig;
    @Autowired
    Environment environment;

    @Test
    void contextLoads() {

        String res = StringUtils.joinWith(",", "a", "b");
        System.out.println(res);

        String[] activeProfiles = environment.getActiveProfiles();
        Arrays.stream(activeProfiles).forEach(System.out::println);
    }

    @Autowired
    DemoController demoController;

    @Test
    void t1() {
        demoController.test();
    }

    @Test
    void t2() {
        demoConfig.test();
    }
}
