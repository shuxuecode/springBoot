package com.zsx.demo.controller;

import com.alibaba.fastjson.JSON;
import com.zsx.demo.po.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("c")
    public Object c(@Validated User user, BindingResult bindingResult) {
        System.out.println("bindingResult");
        StringBuilder sb = new StringBuilder();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            sb.append(allError.getDefaultMessage()).append(" , ");
        }
        System.out.println(sb.toString());
        return user;
    }

    @PostMapping("d")
    public Object d(@Valid User user) {
        return user;
    }
}
