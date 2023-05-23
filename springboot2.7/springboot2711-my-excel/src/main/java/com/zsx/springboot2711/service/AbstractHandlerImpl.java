package com.zsx.springboot2711.service;

import com.zsx.springboot2711.aop.annotation.PrintLog;
import org.springframework.stereotype.Component;

/**
 * @date 2023/5/22
 */
@Component
public class AbstractHandlerImpl extends AbstractHandler {


    @Override
    @PrintLog
    public String test() {
        return null;
    }


    @Override
    public String getType() {
        return "abc";
    }
}
