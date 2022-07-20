package com.zsx.springbootspringevent.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 自定义事件
 *
 * @date 2022/7/20
 */
public class TestEvent extends ApplicationEvent {

    /**
     * 该类型事件携带的信息
     */
    private String msg;

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }


    // get set
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
