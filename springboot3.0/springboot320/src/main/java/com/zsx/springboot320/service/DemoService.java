package com.zsx.springboot320.service;

import com.zsx.springboot320.config.anno.MyAnno;
import com.zsx.springboot320.config.anno.MyLog;
import com.zsx.springboot320.dto.RequestDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @date 2024/2/19
 */
@Service
public class DemoService {


    @MyLog
    @MyAnno
    public Date getNow(RequestDTO requestDTO) {
        return new Date();
    }

}
