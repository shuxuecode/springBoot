package com.example.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动时bean实例化分析
 *
 * @date 2022/4/1
 */
@Component
public class StartBeanInitAnalyzeProcessor implements BeanPostProcessor, PriorityOrdered, ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(StartBeanInitAnalyzeProcessor.class);

    private Map<String, Long> beanMap = new HashMap<>();


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("before beanName={}", beanName);

        beanMap.put(beanName, System.currentTimeMillis());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("after beanName={}", beanName);

        Long startTime = beanMap.get(beanName);

        beanMap.put(beanName, System.currentTimeMillis() - startTime);


        return bean;
    }


    public Map<String, Long> getBeanMap() {
        return beanMap;
    }
}
