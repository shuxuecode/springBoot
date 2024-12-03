package org.z.s.x.springboot.config.test.abc;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * 为什么要把这个类放在这个包下？
 * 因为com.zsx.springboot320.config.aop.LogAspect 这个切面会注册DemoService代理类，
 * 导致Springboot320Application中配置的@ComponentScan中的excludeFilters不生效
 *
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
