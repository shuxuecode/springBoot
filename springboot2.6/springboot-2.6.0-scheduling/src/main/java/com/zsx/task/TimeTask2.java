package com.zsx.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeTask2 implements SchedulingConfigurer {


    /**
     * 循环间隔时间，单位毫秒
     */
    private Long interval = 1000L;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            System.out.println("time is " + new Date());
        }, triggerContext -> {
            // 使用不同的触发器，为设置循环时间的关键，区别于CronTrigger触发器，该触发器可随意设置循环间隔时间，单位为毫秒
            PeriodicTrigger periodicTrigger = new PeriodicTrigger(interval);
            Date nextExecutionTime = periodicTrigger.nextExecutionTime(triggerContext);
            return nextExecutionTime;
        });
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }
}
