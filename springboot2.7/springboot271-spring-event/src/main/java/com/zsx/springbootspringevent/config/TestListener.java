package com.zsx.springbootspringevent.config;

import com.zsx.springbootspringevent.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * <p>
 * 实现ApplicationListener接口，指定监听的事件类型
 *
 * @date 2022/7/20
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent event) {
        String msg = event.getMsg();
        System.out.println("TestListener msg = " + msg);
    }
}
