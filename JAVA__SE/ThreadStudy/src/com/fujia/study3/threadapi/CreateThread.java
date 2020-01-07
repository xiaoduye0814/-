package com.fujia.study3.threadapi;

public class CreateThread {
    public static void main(String[] args) {
        // 1、new Thread()  自动命名Thread- 从0开始
        Thread t1 = new Thread();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
        t1.start();
        System.out.println(t1.getName());
        // 2、如果在构造Thread的时候没有传递或者没有复写Thread的run方法，该Thread将不会调用任何东西，
        // 如果传递了Runnable接口的实例或者复写了Thread的run方法，则会执行该方法的逻辑单元（逻辑代码）
        Thread t3 = new Thread("Myname");
        System.out.println(t3.getName());
        // ()->实现方法的意思
        Thread t4 = new Thread(()->{
            System.out.println("Runnable...");
        });
        Thread t5 = new Thread(()->{
            System.out.println("Runnable...");
        }, "RunnableThread");
        t5.start();
        System.out.println(t5.getName());
    }
}
