package com.zsx.springbootswaggerui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(value = "demoController")
@RestController
public class DemoController {

    @ApiOperation(value = "测试", httpMethod = "GET", notes = "测试一下")
    @GetMapping("/test")
    public String test(@ApiParam("name") @RequestParam String name) {
        return UUID.randomUUID().toString();
    }

}
