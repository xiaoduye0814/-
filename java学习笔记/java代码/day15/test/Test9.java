package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * /*★★
====第九题====================================
通过键盘录入的方式，进行猜数字的游戏。
要求：输入一个1~100之间的数字，
与预先给定数字不同，要给出大或者小的提示。

思路:
1,先产生一个随机数.
2,通过System.in读取一行数据内容.并转换成int的值.
3.建立

*/
public class Test9 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("请输入您猜的数字：");
            try {
                String str = br.readLine();
                if ("quit".equals(str)) {
                    break;
                }
                Random r = new Random();
                int ran = r.nextInt(100);
                if (Integer.parseInt(str) - ran > 0) {
                    System.out.println("大了" + ran);
                    continue;
                }
                if (Integer.parseInt(str) - ran < 0) {
                    System.out.println("小了" + ran);
                    continue;
                }
                if (Integer.parseInt(str) - ran == 0) {
                    System.out.println("哦了" + ran);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
