package com.zsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
public class App {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!!!";
    }

    public static void main(String[] args) {
        // todo
        //SpringApplication.run(App.class, args);

        String configLocation = ConfigFileApplicationListener.CONFIG_LOCATION_PROPERTY + ":file:./a/b/c/";
        configLocation = ConfigFileApplicationListener.CONFIG_ADDITIONAL_LOCATION_PROPERTY + ":file:./a/b/c/";
        String configName = ConfigFileApplicationListener.CONFIG_NAME_PROPERTY + ":appconfig";

        new SpringApplicationBuilder(App.class)
                .properties(configLocation, configName)
                .build().run(args);



        /*
        spring.config.location  最后必须要有"/"
         */
    }
}