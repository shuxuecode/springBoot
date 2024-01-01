package com.zsx;

import com.zsx.bean.TestBean;
import com.zsx.service.DemoService;
import com.zsx.test.bean.AAA;
import com.zsx.test.bean.Parent;
import com.zsx.test.bean.aaa.Anno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

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


    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("打印所有的bean start");
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("打印所有的bean end");
    }


    @Test
    void ss() {
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(Anno.class);
        for (Object obj : map.values()) {
            Parent parent = (Parent) obj;

            System.out.println(parent);

            if (parent instanceof AAA.Aabcdefg) {
                Object a = parent.test("a");
                System.out.println(a);
            } else if (parent instanceof AAA.Babcdefg) {
                Object a = parent.test(new Date());
                System.out.println(a);
            }

        }
    }

}
