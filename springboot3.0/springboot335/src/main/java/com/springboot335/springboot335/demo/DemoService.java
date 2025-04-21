package com.springboot335.springboot335.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private String a = "a";
    private String b = "b";


    public String testGet() {

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        return "get";
    }


    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }
}
