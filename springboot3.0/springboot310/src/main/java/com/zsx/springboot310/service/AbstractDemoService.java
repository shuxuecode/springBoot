package com.zsx.springboot310.service;

public abstract class AbstractDemoService implements DemoService {

    @Override
    public String test(String str) {
        return "Abstract implements";
    }
}
