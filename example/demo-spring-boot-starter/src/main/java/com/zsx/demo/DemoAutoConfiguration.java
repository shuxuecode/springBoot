package com.zsx.demo;

import com.zsx.config.DemoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配类
 *
 * @author ZSX
 */
@Configuration
@ComponentScan("com.zsx")
@EnableConfigurationProperties(value = {DemoProperties.class})
@ConditionalOnProperty(prefix = "demo", name = "enable", havingValue = "true", matchIfMissing = false)
public class DemoAutoConfiguration {

    @Autowired
    DemoProperties demoProperties;

    @Bean
    public String getUrl() {
        return demoProperties.getUrl();
    }


}
