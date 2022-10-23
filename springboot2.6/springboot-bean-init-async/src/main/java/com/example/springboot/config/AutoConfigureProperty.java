package com.example.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @date 2022/10/23
 */
@ConfigurationProperties(prefix = "zsx.config")
public class AutoConfigureProperty {
    private String key;
    private String value;



}
