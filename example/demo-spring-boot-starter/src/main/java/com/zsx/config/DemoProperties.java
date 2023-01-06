package com.zsx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 定义属性配置
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties implements java.io.Serializable {

    private static final long serialVersionUID = 8471755917762607584L;

    /**
     * 是否开启
     */
    private boolean enable;
    private String url;
    private String username;
    private String password;


    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
