package com.springboot335.springboot335;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class Springboot335Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot335Application.class, args);
	}

}
