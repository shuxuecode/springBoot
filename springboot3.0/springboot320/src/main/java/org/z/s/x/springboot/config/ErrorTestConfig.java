package org.z.s.x.springboot.config;

import com.zsx.springboot320.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 为什么要把这个类放在这个包下？
 * 因为com.zsx.springboot320.config.aop.LogAspect 这个切面会注册DemoService代理类，
 * 导致Springboot320Application中配置的@ComponentScan中的excludeFilters不生效
 *
 * @date 2024/2/29
 */

@Configuration
public class ErrorTestConfig {


    @Bean("errorDemoService")
    public DemoService demoService() {
        // 异常
        Integer.valueOf("abc");
        return new DemoService();
    }

}
