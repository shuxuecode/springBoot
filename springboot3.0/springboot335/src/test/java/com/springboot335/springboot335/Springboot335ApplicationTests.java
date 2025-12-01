package com.springboot335.springboot335;

import com.springboot335.springboot335.demo.DemoService;
import com.springboot335.springboot335.demo.TestComponent;
import com.springboot335.springboot335.service.TaskService;
import com.springboot335.springboot335.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest
class Springboot335ApplicationTests {


	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	DemoService demoService;

	@Autowired
	TaskService taskService;

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

		//testService.testGet(1);
		testService.testGet2(1);
	}


	@Test
	void t02() throws ExecutionException, InterruptedException {

		t03();

		IntStream.rangeClosed(1, 10).forEach(item -> {
			CompletableFuture.runAsync(() -> {
				try {
					t03();
				} catch (ExecutionException e) {
					throw new RuntimeException(e);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			});
		});


		TimeUnit.SECONDS.sleep(5L);

	}

	void t03() throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = taskService.task1();
		String res = future.get();

		System.out.println(res);
	}
}
