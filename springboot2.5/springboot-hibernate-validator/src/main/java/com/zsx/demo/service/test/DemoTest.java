package com.zsx.demo.service.test;

/**
 * @date 2022/1/10
 */
public abstract class DemoTest<R extends String, V extends String> {

    public String set(R str) {
        return str;
    }


    public V get(R a, V b) {
        return b;
    }
}
