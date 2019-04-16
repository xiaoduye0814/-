package test;

import java.util.Arrays;


/**
 * /*★★★
====第十一题==================================
字符串由多个数字和空格组成“20 8 0 -1 32 14”，
将字符串中的数字按数值大小升序排列，获取排序后的字符串。

思路:
1,将给定字符串按照规则(空格)进行切割变成字符串数组.
2,将字符串数组中的元素转成int型的值存入int数组中.
3,对数组进行排序.
4,将数组在变成字符串.
    a.整型数组变成字符串可以同临时定义一个容器(StringBuffer),
    对元素进行存储.
    b.在将StringBuffer.toString变成字符串.
*/
public class Test11 {

    public static void main(String[] args) {
        String str = "20 8 0 -1 32 14";
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                sb = sb.append(ch[i]);
            }
        }
        String[] s = sb.toString().split("");
        Arrays.sort(s);
        for (String ss : s) {
            System.out.print(ss);
        }

    }
}
