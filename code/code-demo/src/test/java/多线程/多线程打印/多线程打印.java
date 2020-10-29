package 多线程.多线程打印;

public class 多线程打印 {

    public static void main(String[] args) throws InterruptedException {

        LockObject lockObject = new LockObject();

        ThreadDemo aThread = new ThreadDemo(lockObject, "a", 1, 2);
        ThreadDemo bThread = new ThreadDemo(lockObject, "bb", 2, 3);
        ThreadDemo cThread = new ThreadDemo(lockObject, "ccc", 3, 1);

        aThread.start();
        Thread.sleep(10);

        bThread.start();
        Thread.sleep(10);

        cThread.start();
    }


}
