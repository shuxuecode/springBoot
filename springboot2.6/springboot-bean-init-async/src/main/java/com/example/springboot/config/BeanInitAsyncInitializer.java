package com.example.springboot.config;

import com.example.springboot.listener.BeanInitAsyncApplicationListener;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;

/**
 * @author
 * @date 2022/4/2
 */
public class BeanInitAsyncInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (applicationContext instanceof GenericApplicationContext) {
            System.out.println("BeanInitAsyncInitializer run");
            BeanInitAsyncApplicationListener.attach((GenericApplicationContext) applicationContext);
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
