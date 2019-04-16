package threadstudy;

public class TicketSale {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SaleThread st = new SaleThread();
        new Thread(st).start();
        new Thread(st).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        st.lock = "method";
        new Thread(st).start();
        new Thread(st).start();
    }

}

class SaleThread implements Runnable {

    int num = 100;

    String lock = "";

    public void run() {
        if (lock.equals("method")) {
            while (true) {
                sale();
            }
        } else {
            while (true) {
                synchronized (lock) {
                    if (num == 0) {
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "run()第"
                            + num--
                            + "张票");
                }
            }
        }
    }

    private synchronized void sale() {
        while (true) {
            if (num == 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "sale()第"
                    + num--
                    + "张票");
        }
    }

}
