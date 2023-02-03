package com.zsx.springbootspringevent.config;

import com.zsx.springbootspringevent.event.TestEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 监听器，注解方式
 *
 * @date 2022/7/20
 */
//@Component
public class MsgListenter {

    @EventListener(TestEvent.class)
    public void getMsg(TestEvent event) {
        System.out.println("MsgListenter msg = " + event.getMsg());
    }
}
