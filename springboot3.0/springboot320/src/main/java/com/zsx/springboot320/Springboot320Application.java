package com.zsx.springboot320;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.z.s.x.springboot.config.ErrorTestConfig;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class
        }
)

@ComponentScan(
        basePackages = {
                "com.zsx.springboot320",
                "org.z.s.x.springboot"
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        value = {ErrorTestConfig.class})
        }
)

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
