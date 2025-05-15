import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.BiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Date 2019/4/11 14:41
 **/
public class AAA {


    public static void main(String[] args) {
        System.out.println("abc".endsWith(","));
        System.out.println("abc,".endsWith(","));
        String s = "abc,";
        s += s.endsWith(",") ? "" : ",";
        System.out.println(s);



        String str = "{}";

        JSONObject jsonObject = JSON.parseObject(str);

        System.out.println(jsonObject.toJSONString());
        System.out.println(JSON.toJSONString(jsonObject, true));
    }


    @Test
    public void test() {



    }

}
