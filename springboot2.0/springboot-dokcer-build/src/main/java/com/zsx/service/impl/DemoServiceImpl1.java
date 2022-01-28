package com.zsx.service.impl;

import com.zsx.config.DemoAnno;
import com.zsx.service.DemoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @date 2022/1/25
 */
//@Service
//@Primary
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

    @Override
    @DemoAnno
    public String setex(String key, int time, String value) {
        System.out.println("执行了  DemoServiceImpl1 setex key = " + key + "  value = " + value);
        return "return " + key + "=" + value;
    }

    /**
     * 增加一个重载方法，用于测试
     *
     * @param key
     * @param time
     * @param value
     * @return
     */
    @Override
    @DemoAnno
    public String setex(String key, int time, String value, long seconds) {
        System.out.println("执行了  DemoServiceImpl1 setex key = " + key + " long value = " + value);
        return "return " + key + "=" + value;
    }
}
