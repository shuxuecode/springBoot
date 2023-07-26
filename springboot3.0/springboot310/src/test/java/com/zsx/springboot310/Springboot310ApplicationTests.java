package com.zsx.springboot310;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.ApplicationContextTestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootTest
class Springboot310ApplicationTests {

	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
		String[] activeProfiles = environment.getActiveProfiles();
		Arrays.stream(activeProfiles).forEach(System.out::println);
	}

}
