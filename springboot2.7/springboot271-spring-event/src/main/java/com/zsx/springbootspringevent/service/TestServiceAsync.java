package com.zsx.springbootspringevent.service;

import com.zsx.springbootspringevent.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 异步模式
 *
 * @date 2022/7/20
 */
@Service
public class TestServiceAsync {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceAsync.class);
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public String publish(String msg) {
        LOGGER.info("publish:" + msg);
        long start = System.currentTimeMillis();

        /*
        这种方式是同步方式，事件依赖消费时长
         */
        applicationEventPublisher.publishEvent(new TestEvent(this, "msg:" + msg));
        //System.out.println("Service耗时 " + (System.currentTimeMillis() - start));
        return "";
    }

}
