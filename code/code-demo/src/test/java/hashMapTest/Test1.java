package hashMapTest;

import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    public void test2() {

        int i = 4;
        System.out.println(Integer.toBinaryString(i));

    }

    @Test
    public void test1() {

        for (int i = 10; i < 100; i += 5) {
            int cap = i;

            int n = cap - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            System.out.print(i);
            System.out.print("  ---  ");
            System.out.println(n);
        }


    }
}
