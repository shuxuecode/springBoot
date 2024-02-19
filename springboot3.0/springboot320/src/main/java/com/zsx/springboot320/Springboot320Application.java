package com.zsx.springboot320;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// 开启AspectJ自动代理
@EnableAspectJAutoProxy
public class Springboot320Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot320Application.class, args);
    }

}
