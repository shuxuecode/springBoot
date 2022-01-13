package apacheCommon.lang3;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zsx
 * @date 2021/9/26
 */
public class UnitTest {

    static long startTime = 0;

    //@BeforeEach
    @BeforeAll
    static void before() {
        startTime = System.currentTimeMillis();
    }

    //@AfterEach
    @AfterAll
    static void after() {
        System.out.println("耗时：");
        System.out.println(System.currentTimeMillis() - startTime);
    }


    @Test
    @RepeatedTest(10)
    void t1() {

        String s = StringUtils.joinWith(":", "1", "2", "3");

        //String s = "1" + ":" + "2" + ":" + "3";

        System.out.println(s);


    }

    @Test
    @RepeatedTest(10)
    void t2() {
        String s = RandomStringUtils.randomAlphanumeric(16);
        System.out.println(s);
    }

    @Test
    void t3() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
    }

    @Test
    void t4() {
        System.out.println(SystemUtils.getHostName());
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.getUserDir());
        System.out.println(SystemUtils.getUserHome());
        System.out.println();

        System.out.println(SystemUtils.IS_OS_WINDOWS);
        System.out.println(SystemUtils.IS_OS_LINUX);
        System.out.println();

        System.out.println(SystemUtils.IS_JAVA_1_8);

    }
    @Test
    void t5() {
        Map<String, Map<String, String>> map = Maps.newConcurrentMap();

        System.out.println(map.get(null)); // 报 java.lang.NullPointerException
    }
}
