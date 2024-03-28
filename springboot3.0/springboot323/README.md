

## 扫描自定义注解并注册为spring bean


### 注解定义

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomBean {

    String value() default "";

}
```


### 配置自定义注解扫描器

```java

import com.zsx.springboot323.config.anno.CustomBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

@Configuration
public class CustomBeanScanConfig {

    @Bean
    public BeanDefinitionRegistryPostProcessor beanDefinitionRegistryPostProcessor() {
        return registry -> {
            // 注册自定义注解
            ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
            provider.addIncludeFilter(new AnnotationTypeFilter(CustomBean.class));

            // todo zsx
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

```

### 使用自定义注解


```java
@CustomBean("demoService2")
public class DemoService {

}
```


