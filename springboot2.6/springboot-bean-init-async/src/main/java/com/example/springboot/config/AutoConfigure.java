package com.example.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

/**
 * @date 2022/10/20
 */
// todo zsx
@Configuration
@ConditionalOnProperty(name = "", havingValue = "true", matchIfMissing = true)
//@EnableConfigurationProperties()
public class AutoConfigure implements EnvironmentAware {

    private ConfigurableEnvironment environment;


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;

        // todo zsx
        MutablePropertySources propertySources = this.environment.getPropertySources();
        propertySources.stream().forEach(item -> {
            System.out.println(item);
        });
    }
}
