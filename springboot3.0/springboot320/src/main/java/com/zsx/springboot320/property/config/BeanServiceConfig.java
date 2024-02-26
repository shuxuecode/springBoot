package com.zsx.springboot320.property.config;

import com.zsx.springboot320.property.service.BeanService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2024/2/26
 */


@Configuration
@ConditionalOnMissingBean(name = {"beanService"})
public class BeanServiceConfig {


    @Bean
    public BeanService beanService() {
        System.out.println(8899);
        System.out.println(8899);
        System.out.println(8899);
        System.out.println("beanService不存在，所以手动创建该bean");
        return new BeanService();
    }


}
