package com.zsx;

import com.zsx.test.bean.AAA;
import com.zsx.test.bean.Parent;
import com.zsx.test.bean.ParentFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.boot.test.context.SpringBootTest
class SpringBootTest {


    @Autowired
    ParentFactory parentFactory;

    //@Autowired
    //DemoService2 demoService2;

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
