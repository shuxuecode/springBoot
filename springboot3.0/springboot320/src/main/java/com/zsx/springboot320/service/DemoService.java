package com.zsx.springboot320.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @date 2024/2/19
 */
@Service
public class DemoService {


    public Date getNow(Date date) {
        return new Date();
    }

}
