package com.xiaoduye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ten2Binary {
    //    public static void main(String[] args) {
    //        StringBuffer str = new StringBuffer();
    //        //        for (int num = 653; num / 2 > 0; num /= 2) {
    //        int num = 98;
    //        while (num > 0) {
    //            int yushu = num % 2;
    //            str.append(yushu);
    //            num = num / 2;
    //        }
    //        str.reverse();
    //        System.out.println(str);
    //    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("本程序提供十进制转化八进制");
        String line = br.readLine();
        int num = Integer.parseInt(line);
        StringBuffer str = new StringBuffer();
        while (num > 0) {
            int yushu = num % 16;
            if (yushu > 9) {
                str.append((char) (yushu - 10 + 'A'));
            } else {
                str.append(yushu);
            }
            num = num / 16;
        }
        str.reverse();
        System.out.println(str);
    }

    public static String replace16Binary(int yushu) {
        String yushuNow = String.valueOf(yushu);
        if (yushu <= 15 && yushu >= 10) {
            yushuNow = yushuNow.replace("10", "a").replace("11", "b")
                    .replace("12", "c")
                    .replace("13", "d").replace("14", "e").replace("15", "f");
        }
        return yushuNow;
    }
}
