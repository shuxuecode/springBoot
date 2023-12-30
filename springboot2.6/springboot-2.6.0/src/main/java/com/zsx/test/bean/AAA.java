package com.zsx.test.bean;

import com.zsx.test.bean.aaa.Anno;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class AAA {


    @Anno
    public class Aabcdefg implements Parent<String> {

        @Override
        public boolean test(String s) {
            return false;
        }
    }


    @Anno
    public class Babcdefg implements Parent<Date> {

        @Override
        public boolean test(Date date) {
            return false;
        }
    }
}
