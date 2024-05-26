package com.zsx.springboot323.config;

import com.zsx.springboot323.config.anno.CustomBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * 自定义Bean注解扫描配置
 *
 * @author zsx
 * @date 2024/3/12
 */
@Configuration
public class CustomBeanScanConfig {


    @Bean
    public BeanDefinitionRegistryPostProcessor beanDefinitionRegistryPostProcessor() {
        return registry -> {
            // 注册自定义注解
            ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
            provider.addIncludeFilter(new AnnotationTypeFilter(CustomBean.class));

            // todo 这里需要写死，或者从配置项中读取
            String basePackage = "com.zsx.springboot323";

            for (BeanDefinition beanDefinition : provider.findCandidateComponents(basePackage)) {
                try {
                    Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());

                    String beanName = beanClass.getAnnotation(CustomBean.class).value();

                    beanName = beanName.isEmpty() ? beanClass.getSimpleName() : beanName;

                    registry.registerBeanDefinition(beanName, beanDefinition);

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        };
    }


}
