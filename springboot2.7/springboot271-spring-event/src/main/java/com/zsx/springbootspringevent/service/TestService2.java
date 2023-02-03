package com.zsx.springbootspringevent.service;

import com.zsx.springbootspringevent.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @date 2022/7/20
 */
@Service
public class TestService2 {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public String publish() {
        long start = System.currentTimeMillis();

        /*
        这种方式是同步方式，事件依赖消费时长
         */
        applicationEventPublisher.publishEvent(new TestEvent(this, "test"));
        System.out.println("Service耗时 " + (System.currentTimeMillis() - start));
        return "";
    }

}
