package com.zsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@EnableScheduling // todo

@EnableAspectJAutoProxy(proxyTargetClass = true)
public class App {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
