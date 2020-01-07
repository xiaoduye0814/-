package com.fujia.study3.threadapi;

import java.util.Arrays;

public class CreateThread2 {
    public static void main(String[] args) {
        // 3、如果构造线程对象时未传入ThreadGroup, Thread会默认获取父线程的ThreaddGroup作为自己的ThreadGroup，
        // 此时子线程和父线程会在一个group
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        //        System.out.println(t.getThreadGroup().getName());
        //        System.out.println(Thread.currentThread().getName());
        //        System.out.println(Thread.currentThread().getThreadGroup().getName());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        //        java8 语法
        Arrays.asList(threads).forEach(System.out::println);
        //        for (Thread thread:threads){
        //            System.out.println(thread);
        //        }
    }
}
