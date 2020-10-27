package javaCore.reflectTest.impl;

import javaCore.reflectTest.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("执行业务逻辑代码");
    }
}
