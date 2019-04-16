package threadstudy;

public class ThreadTest {

    public static void main(String[] args) {
        //        new MyThread().start();
        //        new MyThread().start();
        MyThread mt = new MyThread();
        mt.setName("hello");
        mt.setDaemon(true);
        mt.start();
        int num = 0;
        while (true) {
            num++;
            if (num >= 20) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main()" + Thread.currentThread().getName());
        }
    }
}

class MyThread extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run()" + Thread.currentThread().getName());
        }
    }
}