package javaCore;

import java.util.concurrent.ThreadLocalRandom;

public class CodeTest001 {

    // todo xue

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
