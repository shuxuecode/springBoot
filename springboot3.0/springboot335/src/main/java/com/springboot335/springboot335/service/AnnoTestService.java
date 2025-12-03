package com.springboot335.springboot335.service;

import com.springboot335.springboot335.demo.anno.Demo;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class AnnoTestService {


    @Demo(key = "'testDemo'", scene = "test")
    public String testGet() {
        return "get";
    }


    public String testGet2() {

        //String res = this.testGet();

        String res = ((AnnoTestService) AopContext.currentProxy()).testGet();

        return res;
    }


}
