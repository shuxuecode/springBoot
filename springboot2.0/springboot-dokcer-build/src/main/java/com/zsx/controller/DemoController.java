package com.zsx.controller;

import com.zsx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2022/1/25
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    //@Qualifier("DemoServiceBbb")
    private DemoService DemoServiceBbb;

    @GetMapping("get")
    public String get(){

        demoService.set("a", "b");

        //demoService.get();

        DemoServiceBbb.get();

        demoService.setex("a", 2, "a");

        return null;

    }



}
