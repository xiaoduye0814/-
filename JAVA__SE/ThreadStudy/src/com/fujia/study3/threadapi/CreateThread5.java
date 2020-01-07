package com.fujia.study3.threadapi;

public class CreateThread5 {
    private static int count = 1;
    public static void main(String[] args) {
        try {
            for(int i = 0; i<Integer.MAX_VALUE; i++){
                count++;
                new Thread(()->{
                    byte [] bytes =  new byte[1024*1024*2];
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }catch (Error e){
            e.printStackTrace();
        }
        System.out.println("Total create thread num=>"+count);
    }
}
