package com.zsx.service.impl;

import com.zsx.config.DemoAnno;
import com.zsx.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @date 2022/1/25
 */
@Service(value = "demoService")
public class DemoServiceImpl1 implements DemoService {

    @Override
    @DemoAnno
    public String get() {
        System.out.println("执行了   DemoServiceImpl1 11111");
        return "class= DemoServiceImpl1";
    }


    @Override
    @DemoAnno
    public String set(String key, String value) {

        System.out.println("执行了   DemoServiceImpl1 set key = " + key + "  value = " + value);

        return "return " + key + "=" + value;
    }
}
