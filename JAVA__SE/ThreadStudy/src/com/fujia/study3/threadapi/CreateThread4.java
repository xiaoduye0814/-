package com.fujia.study3.threadapi;

public class CreateThread4 {
    private static int count = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                }catch (Error e){
                    e.printStackTrace();
                    System.out.println(count);
                }
            }
            private void add(int i){
                count++;
                add(i+1);
            }
        },"Test", 1 << 24);
        //构造Thread的时候传入stacksize代表着该线程占用的stack大小
        // 如果没有指定stacksize的大小，默认是0，0代表忽略该参数，改参数会被JNI函数使用
        // 该参数在一些平台有效，在一些平台无效 Windows Linux
        // -Xss10M  stacksize
        t1.start();
    }
}
