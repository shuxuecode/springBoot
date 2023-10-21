package com.zsx.springboot310.controller;

import com.zsx.springboot310.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DemoController {

    @Autowired
    private List<DemoService> list;


    @GetMapping("/test")
    public void test() {
        System.out.println("List<DemoService> list size=" + list.size());

        for (DemoService demoService : list) {
            demoService.test("1");
        }


    }


}
