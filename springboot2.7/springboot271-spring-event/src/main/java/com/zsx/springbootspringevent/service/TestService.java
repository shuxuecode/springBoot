package com.zsx.springbootspringevent.service;

import com.zsx.springbootspringevent.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @date 2022/7/20
 */
@Service
public class TestService {

    @Autowired
    private ApplicationContext applicationContext;

    public String publish() {
        applicationContext.publishEvent(new TestEvent(this, "test"));
        return "";
    }

}
