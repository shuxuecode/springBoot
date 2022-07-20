package com.zsx.springbootspringevent;

import com.zsx.springbootspringevent.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSpringEventApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(123);
	}

	@Autowired
	TestService testService;

	@Test void t1(){
		testService.publish();
	}

}
