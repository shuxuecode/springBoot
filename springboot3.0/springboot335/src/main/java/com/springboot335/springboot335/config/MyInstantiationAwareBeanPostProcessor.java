package com.springboot335.springboot335.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Configuration;


/**
 * 1. 实现了BeanPostProcessor，具备其功能。
 * 2. 作为BeanPostProcessor的子接口，增加了在实例化前后及设置显式属性或进行自动装配之前的回调。
 * 常用于抑制某些目标bean的默认实例化，比如创建带特殊标识的代理（如池化目标、延迟初始化目标等），或者实现其他注入策略，如字段注入。
 * 3. 此接口的postProcessPropertyValues方法可扫描并处理标注有注解的字段和方法，将其注入到Bean中。
 */

@Configuration
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    /**
     * 作用：在实例化 bean 之前调用，允许返回一个代理对象来替代实际要实例化的 bean。
     * 用法：如果返回 null，则 Spring 会继续正常实例化 bean；如果返回非 null 对象，则 Spring 会使用这个对象作为 bean 的实例，不再进行后续的实例化过程。
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        // 这里可以返回代理对象， 如果返回 null，则 Spring 会继续正常实例化 bean
        return null;
    }


    /**
     * 作用：在实例化 bean 之后，但在设置属性之前调用。
     * 用法：可以在这里对 bean 进行一些自定义的初始化操作，或者返回一个代理对象来替代实际要使用的 bean。如果返回 null，则 Spring 会继续处理 bean。
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        // 返回 true 继续后续处理，返回 false 停止后续处理（不会调用后续方法）
        return true;
    }


    /**
     * 返回值会影响 postProcessProperties() 是否执行，其中返回 false 的话，是不会执行。
     * 对属性值进行修改，如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用。可以在该方法内对属性值进行修改
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {

        if (beanName.equals("demoService")) {
            // 修改属性值
            MutablePropertyValues mutablePropertyValues = (MutablePropertyValues) pvs;
            mutablePropertyValues.addPropertyValue("a", "111");
        }

        return pvs;
    }
}
