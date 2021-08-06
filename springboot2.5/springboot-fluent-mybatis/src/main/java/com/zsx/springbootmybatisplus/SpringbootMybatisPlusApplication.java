package com.zsx.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan({"com.zsx.springbootmybatisplus.mapper"})
@MapperScan({"com.zsx.springbootmybatisplus.mapper"})
//            com.zsx.springbootmybatisplus.mapper;
public class SpringbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

}
