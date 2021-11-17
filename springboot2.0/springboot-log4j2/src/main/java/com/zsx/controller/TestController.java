package com.zsx.controller;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by ZSX on 2018/12/4.
 *
 * @author ZSX
 */
@RestController
public class TestController {

    //    private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
    private org.apache.logging.log4j.Logger logger2 = LogManager.getLogger(TestController.class);

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/")
    public String test() {

//        logger.info("打印日志：{}", new Date());
        LOGGER.info("slf4j logger = {}", "test");
        logger2.info("打印日志2：{}", new Date());

        return "Hello World!!!";
    }

}
