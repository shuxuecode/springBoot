package com.zsx.service;

/**
 * @date 2022/1/25
 */
public interface DemoService {


    String get();


    String set(String key, String value);

    String setex(String key, int time, String value);

    /**
     * 增加一个重载方法，用于测试
     *
     * @param key
     * @param time
     * @param value
     * @return
     */
    String setex(String key, int time, String value, long seconds);

}

