package org.z.s.x.springboot.config.test.abc;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * @author shuxuecode
 * @date 2024/12/3
 */
@Component
public class ExcludeFilterTest {


    @PostConstruct
    public void test() {
        System.out.println("test");
        System.out.println(Integer.valueOf("abc"));
    }

}
