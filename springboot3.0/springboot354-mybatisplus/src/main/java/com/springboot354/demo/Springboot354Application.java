package com.springboot354.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.springboot354.demo.mapper")
public class Springboot354Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot354Application.class, args);
	}

}
