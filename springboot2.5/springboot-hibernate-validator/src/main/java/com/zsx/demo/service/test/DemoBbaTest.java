package com.zsx.demo.service.test;

import org.springframework.stereotype.Service;

/**
 * @date 2022/1/10
 */
@Service
public class DemoBbaTest extends DemoTest<String, String>{

    @Override
    public String get(String a, String b) {
        return super.get(a, b);
    }
}
