package com.springboot354.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot354.demo.mapper")
public class Springboot354Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot354Application.class, args);
	}

}
