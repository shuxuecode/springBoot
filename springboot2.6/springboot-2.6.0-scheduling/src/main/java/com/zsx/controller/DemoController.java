package com.zsx.controller;

import com.zsx.task.TimeTask;
import com.zsx.task.TimeTask2;
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

    @Autowired
    private TimeTask timeTask;

    /**
     * 动态修改cron表达式
     *
     * @param cron
     * @return
     */
    @GetMapping("/updateCron")
    public String updateCron(String cron) {
        timeTask.setCron(cron);
        return "ok";

        //  改为一秒一执行
        //    http://localhost:8080/updateCron?cron=0/1%20*%20*%20*%20*%20?

    }

    @Autowired
    private TimeTask2 timeTask2;

    /**
     * 动态修改任务执行间隔时间
     *
     */
    @GetMapping("/updateInterval")
    public String updateInterval(Long interval) {
        timeTask2.setInterval(interval);
        return "ok";

        //  改为3秒一执行
        //    http://localhost:8080/updateInterval?interval=3000

    }
}
