package com.zsx.springboot323.service;

import com.zsx.springboot323.config.anno.CustomBean;
import org.springframework.stereotype.Service;

/**
 * @author zsx
 * @date 2024/3/12
 */
// @Service
@CustomBean("demoService2")
public class DemoService {


    public String sayHello(String name) {
        return "hello " + name;
    }

}
