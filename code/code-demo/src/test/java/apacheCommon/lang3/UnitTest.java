package apacheCommon.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;

import java.util.UUID;

/**
 * @author shuxuezhao
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
    void t2(){
        String s = RandomStringUtils.randomAlphanumeric(16);
        System.out.println(s);
    }

    @Test
    void t3(){
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        System.out.println(UUID.randomUUID().toString().replace("-", "").length());
    }
}
