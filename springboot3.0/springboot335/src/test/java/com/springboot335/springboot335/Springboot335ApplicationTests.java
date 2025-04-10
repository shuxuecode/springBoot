package com.springboot335.springboot335;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
class Springboot335ApplicationTests {


	@Autowired
	ApplicationContext applicationContext;

	@Test
	void contextLoads() {

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		Arrays.sort(beanDefinitionNames);

		System.out.println(8899);
		System.out.println(8899);
		System.out.println(8899);
		for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
		System.out.println(8899);
		System.out.println(8899);
		System.out.println(8899);


	}

}
