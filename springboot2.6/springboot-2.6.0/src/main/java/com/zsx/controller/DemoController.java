package com.zsx.controller;

import com.zsx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DemoController {





    @GetMapping("/")
    public String uuid() {
        return UUID.randomUUID().toString();
    }
}
