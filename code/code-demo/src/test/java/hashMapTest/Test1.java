package hashMapTest;

import org.junit.jupiter.api.Test;

public class Test1 {


    @Test
    public void test3() {

        int n = 8;
        for (int i = 0; i < 10; i++) {
            System.out.print(n);
            System.out.print(" ===  ");
            System.out.println(Integer.toBinaryString(n));
            // TODO zsx 
            n = n | n >>> 1;
        }

    }

    @Test
    public void test2() {

        for (int i = 1; i < 20; i++) {
            System.out.print(i);
            System.out.print(" --  ");
            System.out.println(Integer.toBinaryString(i));
        }

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
