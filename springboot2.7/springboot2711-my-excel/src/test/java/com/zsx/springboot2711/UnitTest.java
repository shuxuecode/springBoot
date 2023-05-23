package com.zsx.springboot2711;

import com.zsx.springboot2711.service.AbstractHandler;
import com.zsx.springboot2711.service.AbstractHandlerImpl;
import com.zsx.springboot2711.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UnitTest {


    private Map<String, AbstractHandler> handlerMap = new HashMap<>();

    @Autowired
    public void setHandlerMap(List<AbstractHandler> handlers) {
        handlers.forEach(handler -> handlerMap.put(handler.getType(), handler));
    }


    @Autowired
    DemoService demoService;

    @Autowired
    AbstractHandlerImpl abstractHandlerImpl;

    @Test
    void contextLoads() {

        System.out.println("start");

        AbstractHandler handler = handlerMap.get("abc");

        handler.run();

        System.out.println("end");

    }

    @Test
    void t0() {

        System.out.println("start");

        abstractHandlerImpl.test();

        System.out.println("end");

    }


    @Test
    void t1() {
        System.out.println("start");
        demoService.tt();
        System.out.println("end");
    }

}
