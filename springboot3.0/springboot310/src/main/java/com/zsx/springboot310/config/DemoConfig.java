package com.zsx.springboot310.config;

import com.zsx.springboot310.service.impl.AbstractDemoService1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class DemoConfig implements ApplicationListener<ContextRefreshedEvent> {

    private ApplicationContext applicationContext;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        applicationContext = event.getApplicationContext();
    }


    public void test() {
        AbstractDemoService1 abstractDemoService1
                = (AbstractDemoService1) applicationContext.getBean("abstractDemoService1");

        abstractDemoService1.test("1");
    }

}
