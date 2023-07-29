package com.zsx.springboot310;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot310ApplicationTests {

	@Test
	void contextLoads() {

		String res = StringUtils.joinWith(",", "a", "b");
		System.out.println(res);

	}

}
