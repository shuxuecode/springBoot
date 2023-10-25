package com.zsx.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2021/11/24
 */
@Configuration
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动成功");

        ApplicationContext applicationContext = SpringBeanUtils.getApplicationContext();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("打印Spring容器中的bean start");
        //Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(beanDefinitionNames).forEach(item -> {
            System.out.print((i.getAndIncrement()) + " : ");
            System.out.println(item);
        });

        System.out.println("打印Spring容器中的bean end");
    }
}
