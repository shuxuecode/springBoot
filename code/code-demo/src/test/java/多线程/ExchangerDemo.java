package 多线程;

import org.junit.Test;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

    // 创建交换器
    private static Exchanger<Object> exchanger = new Exchanger<>();

    @Test
    public void t1() {

        Thread thread1 = new Thread(() -> {
            try {
                Object data = exchanger.exchange("线程1的数据");
                System.out.println("线程1交换后的数据： " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Object data = exchanger.exchange("线程2的数据");
                System.out.println("线程2交换后的数据： " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

    }
}
