package com.springboot354.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot354.demo.entity.User;
import com.springboot354.demo.mapper.UserMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Data
@SpringBootTest
class Springboot354ApplicationTests {

	@Test
	void contextLoads() {
	}

	//@Autowired
	//UserRepository userRepository;

	@Autowired
	UserMapper userMapper;



	@Test
	void t03() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", "abc");
		List<User> user2s = userMapper.selectList(queryWrapper);
		System.out.println(user2s);
	}

	@Test
	void t02() {

		User user = new User();
		user.setUsername("abc");
		user.setPassword("123");
		user.setCreatedTime(new Date());

		userMapper.insertOrUpdate(user);

		//System.out.println(user1);

	}

	@Test
	void t01() {



		//User abc = userRepository.findByUsername("abc");
		//
		//System.out.println(abc);


	}
}
