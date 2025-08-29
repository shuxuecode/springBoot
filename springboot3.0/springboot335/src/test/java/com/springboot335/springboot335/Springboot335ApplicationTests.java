package com.springboot335.springboot335;

import com.springboot335.springboot335.demo.DemoService;
import com.springboot335.springboot335.demo.TestComponent;
import com.springboot335.springboot335.service.TestService;
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

	@Autowired
	DemoService demoService;

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


	@Test
	void testGet() {
        String testGet = demoService.testGet();
        System.out.println(testGet);
    }


	@Test
	void testTestComponent() {

		TestComponent testComponent = applicationContext.getBean(TestComponent.class);

		String testGet = testComponent.testGet();

		System.out.println(testGet);

	}

	@Test
	void tt01() {
		//TestService testService = applicationContext.getBean(TestService.class);
		TestService testService = applicationContext.getBean("newTestService", TestService.class);

		testService.testGet(1);
	}
}
