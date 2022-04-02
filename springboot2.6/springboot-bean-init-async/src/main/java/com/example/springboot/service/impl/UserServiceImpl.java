package com.example.springboot.service.impl;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @date 2022/4/1
 */
@Service
public class UserServiceImpl implements UserService, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }

    @Override
    public void getUser(String name) {

    }


}
