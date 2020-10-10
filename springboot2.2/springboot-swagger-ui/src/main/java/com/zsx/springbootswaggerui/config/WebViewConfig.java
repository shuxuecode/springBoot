package com.zsx.springbootswaggerui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebViewConfig implements WebMvcConfigurer {

    private static final String PATH = "/demo";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addStatusController("/swagger-ui.html*", HttpStatus.NOT_FOUND);

        registry.addRedirectViewController(PATH + "/swagger-resources", "/swagger-resources");
        registry.addRedirectViewController(PATH + "/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController(PATH + "/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController(PATH + "/swagger-resources/configuration/security", "/swagger-resources/configuration/security");

//        registry.addRedirectViewController("/documentation", "/documentation/swagger-ui.html");
//        registry.addRedirectViewController("/documentation/", "/documentation/swagger-ui.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(PATH + "/**").addResourceLocations("classpath:/META-INF/resources/");
    }


}
