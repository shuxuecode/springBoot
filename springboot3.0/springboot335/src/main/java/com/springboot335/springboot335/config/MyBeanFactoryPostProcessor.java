package com.springboot335.springboot335.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;


/**
 * // 通过实现 BeanFactoryPostProcessor 接口，
 * // 可以在 Bean 实例化前修改其配置信息，适用于全局调整 Bean 的元数据，如更改属性值或替换占位符。
 */

@Configuration
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("demoService");


        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue("a", "b");
        propertyValues.addPropertyValue("b", "a");

        // todo zsx


        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
