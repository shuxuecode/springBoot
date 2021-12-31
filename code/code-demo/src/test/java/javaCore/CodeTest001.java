package javaCore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class CodeTest001 {

    // todo xue
    @Test
    void t1() throws InterruptedException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss-SSS");
        DateTimeFormatter SSS = DateTimeFormatter.ofPattern("SSS");

        for (int i = 0; i < 30; i++) {
            LocalDateTime now = LocalDateTime.now();
            String format = now.format(dateTimeFormatter);
            String sss = now.format(SSS);

            System.out.println(format);
            System.out.println("百位 " + Integer.parseInt(sss) / 100);
            System.out.println("十位 " + Integer.parseInt(sss) % 100 / 10);
            System.out.println("个位 " + Integer.parseInt(sss) % 100 % 10);
            System.out.println();

            TimeUnit.MILLISECONDS.sleep(50);
        }


    }


    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    int i1 = random.nextInt(10);
                    System.out.println(i1);
                }
            };
            thread.start();
        }
    }


}
