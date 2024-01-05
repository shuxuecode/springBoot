package com.zsx.service.impl;

import com.zsx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AAAService {

    @Autowired
    DemoService demoService;
}
