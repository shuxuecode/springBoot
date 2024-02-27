package com.zsx.springboot320.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @date 2024/2/27
 */
@Component
@ConfigurationProperties(prefix = "myself.config") // 指定配置属性的前缀
public class MyselfConfigProperties {

    private String name = "zsx";



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
