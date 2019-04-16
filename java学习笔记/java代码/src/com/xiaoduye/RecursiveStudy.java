package com.xiaoduye;

/**
 * 递归
 * @author Administrator
 *
 */
public class RecursiveStudy {
    public static void main(String[] args) {
        /**
         * 函数的递归：就是函数自己调用自己，必须要有结束条件
         */
        int n = 8;
        int sum = getSum(n);
        int fibo = getFibo(n);
        System.out.println(sum);
        System.out.println(fibo);
        ten2Binary(98);
    }

    // 设计一个方法，求1~n的和
    static int getSum(int n){
        if (n == 1)
            return 1;
        return getSum(n - 1) + n;
    }

    // 设计一个方法 1 ，1，2，3，5，8，13...,求第n个数是什么
    static int getFibo(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return getFibo(n - 1) + getFibo(n - 2);
    }

    // 设计十进制转二进制
    static void ten2Binary(int num) {
        if (num == 0)
            return;
        int temp = num % 2;
        num = num / 2;
        ten2Binary(num);
        System.out.print(temp);
    }
}

