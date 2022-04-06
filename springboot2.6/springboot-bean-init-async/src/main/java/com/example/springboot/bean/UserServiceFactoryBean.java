package com.example.springboot.bean;

import com.example.springboot.service.UserService;
import com.example.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class UserServiceFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new UserServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }
}
