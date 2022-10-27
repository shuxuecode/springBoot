package com.example.springboot.config;

import com.example.springboot.listener.BeanInitAsyncApplicationListener;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;

/**
 * ApplicationContextInitializer 接口用于在 Spring 容器刷新之前执行的一个回调函数，通常用于向 SpringBoot 容器中注入属性。
 * <p>
 * 这个类的主要作用就是在ConfigurableApplicationContext类型(或者子类型)的ApplicationContext做refresh之前，允许我们对ConfiurableApplicationContext的实例做进一步的设置和处理。
 * <p>
 * ApplicationContextInitializer接口是在spring容器刷新之前执行的一个回调函数。
 * 是在ConfigurableApplicationContext#refresh() 之前调用（当spring框架内部执行 ConfigurableApplicationContext#refresh() 方法的时候或者在SpringBoot的run()执行时），
 * 作用是初始化Spring ConfigurableApplicationContext的回调接口。
 *
 * @author zsx
 * @date 2022/4/2
 */
public class BeanInitAsyncInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (applicationContext instanceof GenericApplicationContext) {
            System.out.println("BeanInitAsyncInitializer run");
            BeanInitAsyncApplicationListener.attach((GenericApplicationContext) applicationContext);
        }

        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println("容器中的bean总数：" + beanDefinitionCount);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }

    @Override
    public int getOrder() {
        // @order 值越小，执行优先级越高
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
