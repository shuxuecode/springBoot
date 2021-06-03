package com.zsx.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zsx
 */
@RestController
public class DemoController {


    @GetMapping("/")
    public String get() {
        return UUID.randomUUID().toString();
    }
}
