package toolTest.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zsx
 * @date 2021/8/31
 */
public class JSONTest2 {

    @Test
    void t1(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "aa");
        jsonObject.put("b", "bb");

        Object extract = JSONPath.extract(jsonObject.toJSONString(), "$['a']");
        System.out.println(extract);

        System.out.println(extract instanceof String);

    }
}
