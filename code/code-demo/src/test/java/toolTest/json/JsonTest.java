package toolTest.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.testng.collections.Maps;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {


    @Test
    void t1() {
        String json = "{\"name\" : \"name\"}";
        int total = 1000;
        double num = 1000000;
        long start = System.nanoTime();
        for (int i = 0; i < total; i++) {
            Map<String, String> map1 = JSON.parseObject(json, new TypeReference<HashMap<String, String>>() {
            });
        }
        long end = System.nanoTime();
        System.out.println("fastjson 耗时：" + (end - start) / num);

        start = System.nanoTime();
        for (int i = 0; i < total; i++) {
            Map<String, String> map2 = GsonUtils.fromJson(json, new TypeToken<HashMap<String, String>>() {
            });
        }
        end = System.nanoTime();
        System.out.println("gson 耗时：" + (end - start) / num);


        start = System.nanoTime();
        for (int i = 0; i < total; i++) {
            Map<String, String> map3 = JsonUtils.parseObjectByType(json, new com.fasterxml.jackson.core.type.TypeReference<HashMap<String, String>>() {
            });
        }
        end = System.nanoTime();
        System.out.println("jackson 耗时：" + (end - start) / num);


    }


    @Test
    void t2() {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "name");

        int total = 1000;
        double num = 1000000;

        long start = System.nanoTime();
        for (int i = 0; i < total; i++) {
            JSON.toJSONString(map);
        }
        long end = System.nanoTime();
        System.out.println("fastjson 耗时：" + (end - start) / num);


        start = System.nanoTime();
        for (int i = 0; i < total; i++) {
            GsonUtils.toJson(map);
        }
        end = System.nanoTime();
        System.out.println("gson 耗时：" + (end - start) / num);


        start = System.nanoTime();
        for (int i = 0; i < total; i++) {
            JsonUtils.toJSONString(map);
        }
        end = System.nanoTime();
        System.out.println("jackson 耗时：" + (end - start) / num);

    }

}
