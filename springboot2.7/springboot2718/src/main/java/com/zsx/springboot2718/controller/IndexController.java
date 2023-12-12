package com.zsx.springboot2718.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2023/12/12
 */
@RestController
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

}
