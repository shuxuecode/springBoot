package com.zsx.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeTask implements SchedulingConfigurer {


    @Value("${scheduling.cron}")
    private String cron;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //taskRegistrar.addTriggerTask(() -> {
        //    System.out.println("time is " + new Date());
        //}, triggerContext -> {
        //    // 使用CronTrigger触发器，可动态修改cron表达式来操作循环规则
        //    CronTrigger cronTrigger = new CronTrigger(cron);
        //    Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
        //    return nextExecutionTime;
        //});
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
