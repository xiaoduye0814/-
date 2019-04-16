package threadstudy;

public class TicketsSale1 {

    /**
     * 多线程售票，同时开启四个线程售票
     * 需要同步的多段代码要用同一把锁
     * 死锁：
     */
    public static void main(String[] args) {
        /*
         * 四个线程运行四个售票程序 new SaleThread().start(); new SaleThread().start(); new
         * SaleThread().start(); new SaleThread().start();
         */
        SaleThread1 st = new SaleThread1();
        new Thread(st).start();
        new Thread(st).start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        st.lock = "method";
        new Thread(st).start();
        new Thread(st).start();
    }
}

class SaleThread1 implements Runnable //extends Thread 
{
    int tickets = 100;
    String lock = "";
    public void run() {
        if (lock.equals("method")) {
            while (true) {
                sale();
            }
        } else {
            while (true) {
                synchronized (this) { //每个对象都可以作为同步的锁，对象都有一个标志位(0、1)，锁旗标
                //                    sale();
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()
                                + "  ： is sale " + tickets--);
                    }
                }
            }
        }
    }

    //同步函数，同步函数用的锁：this  (st)
    public synchronized void sale() {
        //        synchronized (lock) {
        //
        //        }
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + " ： sale() is sale " + tickets--);
        }
    }
}
