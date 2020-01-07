package com.fujia.study3.daemon;

public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            Thread t2 = new Thread(()->{
                try {
                    while (true){
                        System.out.println("do something");
                        Thread.sleep(5_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            // 守护线程
            // A --------------------------------------->  B
            // 心跳 health check 判断是否还存在链接， 如果不存在， 直接退出，存在的话一直存在
            // setDaemon必须在start之前，线程没有运行的时候设置
            t2.setDaemon(true);
            t2.start();
            try {
                Thread.sleep(1_000);
                System.out.println("Thread1 finished down.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        t1.setDaemon(true);
        t1.start();
    }
}
