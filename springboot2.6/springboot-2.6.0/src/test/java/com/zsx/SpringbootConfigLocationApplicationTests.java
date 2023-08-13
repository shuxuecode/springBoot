package com.zsx;

import com.zsx.bean.TestBean;
import com.zsx.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootConfigLocationApplicationTests {


    @Autowired
    DemoService demoService;

    @Autowired
    TestBean testBean;

    @Resource
    TestBean testBean1;

    @Test
    void t3() {
        String res = testBean1.testUuid();
        System.out.println(res);
    }

    @Test
    void t2() {
        String res = testBean.testUuid();
        System.out.println(res);
    }

    @Test
    void t1() {
        System.out.println(demoService.uuid());
    }


    @Test
    void contextLoads() {
    }

}
