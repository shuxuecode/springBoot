package com.springboot335.springboot335.config;

import com.springboot335.springboot335.demo.TestComponent;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;


/**
 * 扩展了标准的BeanFactory PostProcessor SPI，允许在常规的BeanFactoryPostProcessor处理启动前注册额外的bean定义。
 * 具体来说，BeanDefinitionRegistryPostProcessor能够注册更多bean定义，并进一步配置BeanFactory PostProcessing实例。
 */

@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * 在标准初始化后修改应用程序上下文的内部bean定义注册表。所有常规bean定义都将被加载，但还没有bean被实例化。这允许在下一个后处理阶段开始之前添加更多的bean定义。
     * 参数：BeanDefinitionRegistry registry - 提供了对Bean定义注册表的访问，允许添加、修改或删除Bean定义。
     * 作用：此方法在所有Bean定义加载完成之后、Bean实例化之前被调用。开发者可以在此方法中自定义修改Bean定义，例如添加新的Bean定义、修改现有Bean定义的属性或删除不需要的Bean定义。
     *
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        // 创建bean定义
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(TestComponent.class);

        // 设置属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("a", "测试");
        propertyValues.addPropertyValue("b", "属性");

        beanDefinition.setPropertyValues(propertyValues);

        // 注册bean定义
        registry.registerBeanDefinition("testComponent", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionRegistryPostProcessor.super.postProcessBeanFactory(beanFactory);
    }
}
