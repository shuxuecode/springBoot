package com.zsx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {


    @GetMapping("/")
    public String t() {
        return UUID.randomUUID().toString();
    }

}
