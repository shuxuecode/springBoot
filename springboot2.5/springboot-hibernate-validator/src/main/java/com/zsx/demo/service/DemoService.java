package com.zsx.demo.service;

import com.alibaba.fastjson.JSON;
import com.zsx.demo.service.test.DemoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @date 2022/1/10
 */
@Service
public class DemoService<R extends String, V extends String> {

    @Autowired
    private Map<String, DemoTest<R, V>> map;

    public V test(R str, V res){

        System.out.println(JSON.toJSONString(map, true));
        System.out.println(map.get("demoAaaTest"));

        DemoTest<R, V> demoTest = map.get("demoAaaTest");

        if (demoTest != null) {
            V v = demoTest.get(str, res);
            return v;
        }

        return null;
    }
}
