package com.example.springboot270;

import com.example.springboot270.service.OperateHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot270ApplicationTests {

	@Autowired
	List<OperateHandler> list;

	@Test
	void contextLoads() {
		System.out.println(list.size());
		OperateHandler operateHandler = list.stream().filter(item -> item.match(null, "")).findFirst().orElse(null);
		operateHandler.handle(null, "");
	}

}
