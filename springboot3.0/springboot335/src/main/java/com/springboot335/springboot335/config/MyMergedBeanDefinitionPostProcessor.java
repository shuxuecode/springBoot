package com.springboot335.springboot335.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;


/**
 * 在 Spring 容器合并 Bean 定义之后（即合并父 Bean 和子 Bean 定义的结果之后）且在 Bean 实例化之前，
 * 对最终的 Bean 定义进行额外的处理或调整。此接口常用于定制修改或增强 Bean 定义的属性。
 */

@Configuration
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {


    /**
     * 此方法在Spring容器合并Bean定义之后但在Bean实例化之前执行。
     * 开发者可在其中访问和修改合并后的Bean定义，包括调整Bean属性或其依赖关系。
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if (beanName.equals("demoService")) {
            // 修改属性值
            beanDefinition.getPropertyValues().addPropertyValue("a", "222");
        }
    }


    /**
     * 此方法允许在容器刷新过程中重置已合并的 Bean 定义。这通常用于在多次刷新容器时避免 Bean 定义的缓存问题。
     * 不过，这个方法的使用场景相对较少，因为大多数应用不会频繁地刷新容器。
     *
     * @param beanName
     */
    @Override
    public void resetBeanDefinition(String beanName) {

    }
}
