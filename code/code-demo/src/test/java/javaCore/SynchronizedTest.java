package javaCore;

/**
 * todo
 */
public class SynchronizedTest {

    public static void main(String[] args) {



    }

    private int a = 0;

    public void add() {
        synchronized (this) {
            a++;
            synchronized (this) {
                a++;
                synchronized (this) {
                    a++;
                }
            }
        }
    }

}
