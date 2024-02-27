package com.zsx.springboot320;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// 开启AspectJ自动代理
@EnableAspectJAutoProxy
public class Springboot320Application {

    public static void main(String[] args) {

        // 第一种启动方式
        // SpringApplication.run(Springboot320Application.class, args);

        // 第二种启动方式，支持定制配置， todo 这种方式不生效
        new SpringApplicationBuilder(Springboot320Application.class)
                .properties("myself.config.name=appStart")
                .run(args);
    }

}
