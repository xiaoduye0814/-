package com.fujia.study3.daemon;

public class DaemonThread1 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"running");
                Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName()+"runed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // runnable -> running | dead  -> blocked --> treamined
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
