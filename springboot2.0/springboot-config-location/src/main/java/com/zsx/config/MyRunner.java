package com.zsx.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 *
 */
@Configuration
public class MyRunner implements CommandLineRunner {


    @Resource
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动");
        System.out.println(environment.getDefaultProfiles().length);
        System.out.println(environment.getActiveProfiles().length);
        if (environment.getActiveProfiles().length > 0) {
            System.out.println(environment.getActiveProfiles()[0]);
        }
        System.out.println();
        System.out.println(environment.getProperty(ConfigFileApplicationListener.ACTIVE_PROFILES_PROPERTY));
        System.out.println(environment.getProperty(ConfigFileApplicationListener.CONFIG_LOCATION_PROPERTY));
        System.out.println(environment.getProperty(ConfigFileApplicationListener.CONFIG_NAME_PROPERTY));
        System.out.println(ConfigFileApplicationListener.CONFIG_LOCATION_PROPERTY);
    }
}
