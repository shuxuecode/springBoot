package com.zsx.demo.service;

import com.alibaba.fastjson.JSON;
import com.zsx.demo.service.test.DemoTest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @date 2022/1/10
 */
@Service
public class DemoService<R extends String, V extends String> {

    private Map<String, DemoTest<R, V>> map;

    public Map<String, DemoTest<R, V>> getMap() {
        return map;
    }

    public void setMap(Map<String, DemoTest<R, V>> map) {
        this.map = map;
    }

    public String test(String str){

        System.out.println(8899);
        System.out.println(JSON.toJSONString(map, true));
        System.out.println(map.get("AAA"));

        return str;
    }
}
