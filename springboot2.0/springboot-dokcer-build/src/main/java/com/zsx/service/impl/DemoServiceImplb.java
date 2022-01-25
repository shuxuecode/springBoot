package com.zsx.service.impl;

import com.zsx.config.DemoAnno;
import com.zsx.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @date 2022/1/25
 */
@Service("DemoServiceBbb")
public class DemoServiceImplb implements DemoService {



    @Override
    @DemoAnno("bbb")
    public String get() {
        System.out.println("执行了   DemoServiceImplb bbbbb");
        return "class= DemoServiceImplb";
    }


    @Override
    @DemoAnno("bbb")
    public String set(String key, String value) {

        System.out.println("执行了 DemoServiceImplb set key = " + key + "  value = " + value);

        return "return " + key + "=" + value;
    }
}
