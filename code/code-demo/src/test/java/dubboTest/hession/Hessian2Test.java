package dubboTest.hession;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * 采用的是dubbo缺省协议，序列化方式是Hessian 二进制序列化，在反序列化时会出现父类的同名属性覆盖子类的同名属性问题，所以就变成null
 *
 * @date 2021/10/9
 *
 * <dependency>
 * <groupId>com.alibaba</groupId>
 * <artifactId>dubbo</artifactId>
 * <!--  <version>2.6.8</version>-->
 * <version>2.5.9</version>
 * <!--  <version>2.5.8</version>-->
 * </dependency>
 * <p>
 * <p>
 * 序列化类：com.alibaba.com.caucho.hessian.io.JavaSerializer
 * 反序列化类：com.alibaba.com.caucho.hessian.io.JavaDeserializer
 *
 * <p>
 * 2.5.8 有 hessian2 序列化 问题
 * 2.5.9 后修复了，可以看 JavaSerializer 类，构造函数多了一行代码： Collections.reverse(fields);
 * <p>
 * 获取当前class的所有字段，接着获取父类的所有字段。
 * 序列化的时候，所有字段都放在一个ArrayList里，然后依次写入到二进制流中，
 * 反序列化的时候，所有字段放在了一个HashMap里，HashMap的key不能重复，
 * 悲剧就出现了，如果子类和父类有同名的字段就会有问题，父类的值会把子类的值覆盖掉。
 * JavaDeserializer类的getFieldMap方法
 */
public class Hessian2Test {


    @Test
    void t1() throws IOException {

        ChildrenVO childrenVO = new ChildrenVO();
        childrenVO.setId(1L);
        childrenVO.setName("test name");
        childrenVO.setAge(18);
        childrenVO.setBirthday(new Date());

        byte[] bytes = serialize(childrenVO);

        Object obj = deserialize(bytes);

        System.out.println(JSON.toJSONString(obj));
    }

    @Test
    void t2() throws IOException {


    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);
        byte[] cc = null;
        try {
            if (obj == null) throw new NullPointerException();
            ho.writeObject(obj);
            ho.flushBuffer();
            cc = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ho.close();
        }
        return cc;

    }

    public static Object deserialize(byte[] by) throws IOException {
        try {
            if (by == null) throw new NullPointerException();
            ByteArrayInputStream is = new ByteArrayInputStream(by);
            Hessian2Input hi = new Hessian2Input(is);
            return hi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
