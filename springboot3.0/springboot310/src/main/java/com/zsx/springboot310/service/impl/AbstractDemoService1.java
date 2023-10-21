package com.zsx.springboot310.service.impl;

import com.zsx.springboot310.service.AbstractDemoService;
import org.springframework.stereotype.Service;

@Service
public class AbstractDemoService1 extends AbstractDemoService {


    @Override
    public String test(String str) {
        System.out.println("AbstractDemoService1 run");
        return super.test(str);
    }
}
