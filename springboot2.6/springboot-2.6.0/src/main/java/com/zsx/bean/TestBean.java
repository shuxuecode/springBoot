package com.zsx.bean;

import com.zsx.service.DemoService;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean {


    private DemoService demoService;


    public String testUuid() {
        return demoService.uuid();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        demoService = new DemoService();
    }
}
