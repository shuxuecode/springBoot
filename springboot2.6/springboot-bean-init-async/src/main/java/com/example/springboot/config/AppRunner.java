package com.example.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @date 2022/4/1
 */
@Component
public class AppRunner implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private StartBeanInitAnalyzeProcessor startBeanInitAnalyzeProcessor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("启动完成... ...");

        //Map<String, Long> beanMap = startBeanInitAnalyzeProcessor.getBeanMap();
        //for (Map.Entry<String, Long> entry : beanMap.entrySet()) {
        //    logger.info("bean加载耗时， beanName= {} , cost= {}ms", entry.getKey(), entry.getValue());
        //}

        Map<String, StartBeanInitAnalyzeProcessor.BeanInfo> beanInfoMap = startBeanInitAnalyzeProcessor.getBeanInfoMap();
        Collection<StartBeanInitAnalyzeProcessor.BeanInfo> beanInfos = beanInfoMap.values();
        beanInfos = beanInfos.stream().sorted(Comparator.comparing(StartBeanInitAnalyzeProcessor.BeanInfo::getCostTime)).collect(Collectors.toList());

        for (StartBeanInitAnalyzeProcessor.BeanInfo beanInfo : beanInfos) {
            logger.info("bean加载耗时， beanName= {} , cost= {}ms", beanInfo.getBeanName(), beanInfo.getCostTime());
        }


        System.out.println(System.getProperty("server.port"));
    }
}
