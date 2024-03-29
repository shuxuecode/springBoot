package com.zsx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @date 2021/11/8
 */
@SpringBootApplication
@MapperScan({"com.zsx.dao"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
