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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private Map<String, BeanInfo> beanInfoMap = new HashMap<>();

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


        beanInfoMap.put(beanName, new BeanInfo(beanName, System.currentTimeMillis()));

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("after beanName={}", beanName);

        Long startTime = beanMap.get(beanName);

        beanMap.put(beanName, System.currentTimeMillis() - startTime);

        BeanInfo beanInfo = beanInfoMap.get(beanName);
        beanInfo.setCostTime(System.currentTimeMillis() - beanInfo.getCostTime());
        beanInfoMap.put(beanName, beanInfo);

        return bean;
    }


    public Map<String, Long> getBeanMap() {
        return beanMap;
    }

    public Map<String, BeanInfo> getBeanInfoMap() {
        return beanInfoMap;
    }


    class BeanInfo {
        private String beanName;
        private long costTime;

        public BeanInfo(String beanName, long costTime) {
            this.beanName = beanName;
            this.costTime = costTime;
        }

        public String getBeanName() {
            return beanName;
        }

        //public void setBeanName(String beanName) {
        //    this.beanName = beanName;
        //}

        public long getCostTime() {
            return costTime;
        }

        public void setCostTime(long costTime) {
            this.costTime = costTime;
        }
    }
}
