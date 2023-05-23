package com.zsx.springboot2711.service;


import com.zsx.springboot2711.aop.annotation.PrintLog;

/**
 * @date 2023/5/22
 */
public abstract class AbstractHandler {

    @PrintLog
    public String run() {
        return test();
    }

    abstract String test();

    public abstract String getType();
}
