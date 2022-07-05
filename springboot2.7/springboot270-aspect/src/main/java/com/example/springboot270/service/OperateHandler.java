package com.example.springboot270.service;

/**
 * @date 2022/7/5
 */
public abstract class OperateHandler<T> {

    public abstract boolean match(T operate, String str);

    public abstract String handle(T operate, Object obj);
}
