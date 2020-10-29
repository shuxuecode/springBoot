package 多线程.多线程打印;

public class ThreadDemo extends Thread {
    private LockObject lockObject;
    private String str;

    private int nowFlag;
    private int nextFlag;


    public ThreadDemo(LockObject lockObject, String str, int nowFlag, int nextFlag) {
        this.lockObject = lockObject;
        this.str = str;
        this.nowFlag = nowFlag;
        this.nextFlag = nextFlag;
    }

    @Override
    public void run() {
        synchronized (lockObject) {
            for (int i = 0; i < 10; i++) {

                while (lockObject.flag != nowFlag) {
                    try {
                        lockObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(str);
                lockObject.flag = nextFlag;

                lockObject.notifyAll();
            }
        }

    }
}
