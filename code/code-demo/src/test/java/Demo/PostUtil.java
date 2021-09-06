package Demo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class PostUtil {

    static String postUrl = "http://zhiyuan.hebeeb.com/api/College/Distribute";
    static String Cookie = "test-cookie-23232323";


    public static void main(String[] args) {
//        请求参数，里面包含分页
        JSONObject params = JSONObject.parseObject("{\"size\": 15, \"page\": 1, \"sort\": \"yxdm,year desc\", \"parameters\": {\"a.kldm\": \"0\"}}");
        System.out.println(params);

        String result = loadData(postUrl, params.toJSONString());
        System.out.println("第一页返回数据：" + result);
        JSONObject object = JSONObject.parseObject(result);
//        得到总条数
        int total = object.getIntValue("total");
//        每页条数
        int size = 15;
//        总页数
        int totalPage = total / size;
        if (total % size != 0) {
            totalPage += 1;
        }

        System.out.println(totalPage);

        for (int i = 2; i <= totalPage; i++) {
            params.put("page", i);// 每次修改页码
            result = loadData(postUrl, params.toJSONString());
            System.out.println("第" + i + "页返回数据：" + result);
        }
    }

    public static String loadData(String url, String params) {
        try {
            URL wsUrl = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Cookie", Cookie);

            OutputStream os = conn.getOutputStream();
            os.write(params.getBytes(Charset.forName("UTF-8")));

            InputStream is = conn.getInputStream();

            byte[] b = new byte[1024];
            int len = 0;
            StringBuffer buffer = new StringBuffer();
            while ((len = is.read(b)) != -1) {
                String ss = new String(b, 0, len, "UTF-8");
                buffer.append(ss);
            }
            is.close();
            os.close();
            conn.disconnect();

            String resultStr = buffer.toString();
//            System.out.println(resultStr);
            return resultStr;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void post1() {
        String url = "";
        String params = "";
        try {
            URL wsUrl = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();

            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

            OutputStream os = conn.getOutputStream();
            os.write(params.getBytes(Charset.forName("UTF-8")));

            InputStream is = conn.getInputStream();

            byte[] b = new byte[1024];
            int len = 0;
            StringBuffer buffer = new StringBuffer();
            while ((len = is.read(b)) != -1) {
                String ss = new String(b, 0, len, "UTF-8");
                buffer.append(ss);
            }
            is.close();
            os.close();

            Map<String, List<String>> headerFields = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("key : " + key);
                for (String s : value) {
                    System.out.println("value : " + s);
                }
                System.out.println();
            }

            String cookie = conn.getHeaderField("Set-Cookie");
            System.out.println("cookie : " + cookie);

            conn.disconnect();

            String resultStr = buffer.toString();
            System.out.println(resultStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
