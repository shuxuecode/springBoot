import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 */
public class Test002 {

    @Test
    void t1(){
        long time = System.currentTimeMillis();

        String timeStr = String.valueOf(time);

        System.out.println(timeStr);

        DateTime parse = DateTime.parse("9999-12-31");
        System.out.println(parse);
//        time = parse.getMillis();

        String binaryString = Long.toBinaryString(time);
        System.out.println(binaryString);
        System.out.println(binaryString.length());


        long l = Long.parseLong("01111111111111111111111111111111111111111", 2);

        System.out.println(l);

        Date date = new Date(l);
        System.out.println(date);


    }
}
