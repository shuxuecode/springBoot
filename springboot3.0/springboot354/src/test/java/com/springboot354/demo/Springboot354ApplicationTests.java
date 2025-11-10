package com.springboot354.demo;

import com.alibaba.fastjson2.JSON;
import com.springboot354.demo.entity.User;
import com.springboot354.demo.repository.UserRepository;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Data
@SpringBootTest
class Springboot354ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserRepository userRepository;




	@Test
	void t02() {

		User user = new User();
		user.setUsername("abc");
		user.setPassword("123");
		user.setCreatedTime(new Date());

		User user1 = userRepository.save(user);

		System.out.println(user1);

	}

	@Test
	void t01() {

		User abc = userRepository.findByUsername("abc");

		System.out.println(abc);
		System.out.println(JSON.toJSONString(abc));


	}
}
