package com.zsx.springboot2711.service;

import com.zsx.springboot2711.aop.annotation.PrintLog;
import org.springframework.stereotype.Service;

/**
 * @date 2023/5/22
 */
@Service
public class DemoService {


    @PrintLog
    public void tt() {
        System.out.println(1234);
    }
}
