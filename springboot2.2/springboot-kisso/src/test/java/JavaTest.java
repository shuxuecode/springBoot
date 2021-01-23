import com.baomidou.kisso.SSOHelper;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

public class JavaTest {


    @Test
    public void test1() {
        String secretKey = SSOHelper.getHS512SecretKey();
        System.out.println(secretKey);


    }

    @Test
    public void test2(){

        double v = ((double) Math.abs("".hashCode()) % 1000) / 1000;
        System.out.println(v);

        v = ((double) Math.abs("".hashCode()) % 1000) / 1000;
        System.out.println(v);
    }

}
