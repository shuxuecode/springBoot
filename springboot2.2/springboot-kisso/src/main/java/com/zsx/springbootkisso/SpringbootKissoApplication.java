package com.zsx.springbootkisso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class
})
@EnableScheduling // 开启定时任务
public class SpringbootKissoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKissoApplication.class, args);
    }

}
