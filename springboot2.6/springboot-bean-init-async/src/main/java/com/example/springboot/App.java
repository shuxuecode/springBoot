package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(
		exclude = {
				GroovyTemplateAutoConfiguration.class // 只要在pom里引入groovy的jar包就会加载GroovyMarkupConfigurer，通过排包方式去除
		}
)
@ImportResource(locations = {"classpath:spring/spring-bean.xml"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
