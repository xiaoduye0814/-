package com.fujia.study3.threadapi;

// class 信息、变量修饰符 栈-->方法区
public class CreateThread3 {

    // 栈-->方法区
    private int i = 0;

    // 栈-->方法区 bytes名称4个字节
    // bytes的值 堆
    private byte[] bytes = new byte[1024];

    private static int count = 0;

    // JVM will craete a thread named main
    public static void main(String[] args) {
        // stack size 栈的大小
        // create JVM stack 虚拟机栈
        // start0() 本地方法区，c++语法
        int j = 0;
        int [] arr = new int[1024];
        try {
            // 存在虚拟机栈中， 存在方法入口，但是没有方法出口，
            add(0);
        }catch (Error error){
            // StackOverflowError栈溢出 压栈征23157
             error.printStackTrace();
            System.out.println(count);
        }

    }

    private static void add(int i){
        ++count;
        add(i+1);
    }
}
