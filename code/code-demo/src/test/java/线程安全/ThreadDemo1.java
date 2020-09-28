package 线程安全;

public class ThreadDemo1 {

    public static void main(String[] args) {
        new ThreadDemo1().test();

        while (true) {


        }
    }


    public synchronized void test() {
        System.out.println("开始");
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("5秒后打印");
        });
        thread.setDaemon(true);
        thread.setName("myThread");
        thread.start();

    }

}
