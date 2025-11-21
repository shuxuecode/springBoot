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


        //String str = "{\"userName\":\"张三\",\"userAge\":18}";
        String str = "{\"user_name\":\"张三1\",\"userName\":\"张三2\",\"user_age\":18}";

        DDD ddd = JSON.parseObject(str, DDD.class);

        System.out.println(JSON.toJSONString(ddd));

    }

    public static class DDD {
        private String userName;

        private Integer userAge;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getUserAge() {
            return userAge;
        }

        public void setUserAge(Integer userAge) {
            this.userAge = userAge;
        }
    }
}
