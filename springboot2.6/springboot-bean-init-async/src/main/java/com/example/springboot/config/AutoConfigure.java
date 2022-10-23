package com.example.springboot.config;

import org.codehaus.groovy.tools.shell.RelaxedParser;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;

/**
 * @date 2022/10/20
 */
// todo zsx
@Configuration
@ConditionalOnProperty(name = "zsx.config.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(value = {AutoConfigureProperty.class})
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

        PropertySourcesPropertyResolver propertySourcesPropertyResolver = new PropertySourcesPropertyResolver(propertySources);

        AutoConfigureProperty autoConfigureProperty = new AutoConfigureProperty();

        //RelaxedDataBinder

        // todo zsx



        //    properties = new AccelerateProperties();
        //
        //        MutablePropertySources propertySources = environment.getPropertySources();
        //        new RelaxedDataBinder(properties, PREFIX).bind(new PropertySourcesPropertyValues(propertySources));
    }
}
