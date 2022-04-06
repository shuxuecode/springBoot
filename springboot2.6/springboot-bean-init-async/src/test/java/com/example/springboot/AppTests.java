package com.example.springboot;

import com.example.springboot.App;
import com.example.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = App.class)
class AppTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserService userService;

	@Test void t1(){
		userService.getUser("a");
	}
}
