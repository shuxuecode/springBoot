package com.zsx.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @date 2022/1/24
 */
@Component
public class TestTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTask.class);


    @Scheduled(cron = "*/2 * * * * *")
    //    @Scheduled(cron = "*/5 * * * * * ")
    public void t1(){

        Random random = new Random();

        int num = random.nextInt(99);

        LOGGER.info("LOGGER 打印日志 {}", num);
        System.out.println("System.out 打印日志 " + num);
    }


}
