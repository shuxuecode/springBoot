package com.zsx;

import com.zsx.bean.TestBean;
import com.zsx.service.DemoService;
import com.zsx.test.bean.AAA;
import com.zsx.test.bean.Parent;
import com.zsx.test.bean.ParentFactory;
import com.zsx.test.bean.aaa.Anno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@org.springframework.boot.test.context.SpringBootTest
class SpringBootTest {


    @Autowired
    ParentFactory parentFactory;


    @Test
    void t1() {
        List<Parent> parents = parentFactory.getParents();

        System.out.println("print parentFactory start");
        for (Parent parent : parents) {
            System.out.println(parent);
            if (parent instanceof AAA.Aabcdefg) {
                Object res = parent.test("123");
                System.out.println(res);
            }
        }
        System.out.println("print parentFactory end");
    }


}
