package com.zsx.springbootkisso.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("系统启动成功");
        System.out.println("系统启动成功");
        System.out.println("系统启动成功");

    }
}
