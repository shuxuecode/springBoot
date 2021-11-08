package com.zsx.demo.controller;

import com.zsx.demo.po.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @date 2021/11/8
 */
@RestController
public class TestController {

    @GetMapping("a")
    public String a(String name) {
        return "参数：" + name;
    }

    @PostMapping("b")
    public Object b(@RequestBody @Valid User user) {
        return user;
    }
}
