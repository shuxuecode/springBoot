import org.apache.commons.lang.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.util.Optional;

/**
 * @date 2022/11/16
 */
public class JavaTest {

    @Test
    void t1(){
        String str = DigestUtils.md5DigestAsHex(
                Optional.ofNullable("test str")
                        .map(conf -> conf.getBytes())
                        .orElse(ArrayUtils.EMPTY_BYTE_ARRAY));

        System.out.println(str);
    }

}
