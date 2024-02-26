package com.zsx.springboot320.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @date 2024/2/26
 */

/**
 * 总结差异：
 * classpath: 用于加载类路径上的一个特定资源，返回第一个匹配的资源。
 * classpath*: 用于加载类路径上的所有匹配资源，返回所有匹配的资源数组。
 *
 * 使用场景：
 * classpath: 适合你知道资源位置，并且只希望加载一个资源的情况。
 * classpath*: 适合你需要加载类路径上所有给定模式的资源，例如在自动检测配置文件或插件模块时。
 * 需要注意的是，在某些情况下，使用 classpath*: 可能会导致性能上的考虑，因为它需要搜索所有类路径位置。而 classpath: 由于仅搜索和加载第一个匹配的资源，通常会更快。
 */

@Configuration
@PropertySource(value = {"classpath*:property/custom.properties"})
public class CustomConfig {


    @Value("${app.name}")
    private String name;


    @Value("${mysql.url}")
    private String url;


    // getter

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
