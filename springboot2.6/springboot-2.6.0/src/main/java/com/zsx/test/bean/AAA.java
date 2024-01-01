package com.zsx.test.bean;

import com.zsx.test.bean.aaa.Anno;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class AAA {


    @Anno
    public class Aabcdefg implements Parent<String> {

        @Override
        public Object test(String s) {
            return "入参是一个字符串";
        }
    }


    @Anno
    public class Babcdefg implements Parent<Date> {

        @Override
        public Object test(Date date) {
            return "入参是一个日期类型";
        }
    }
}
