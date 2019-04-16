package test;

/**
 * 
/*★★★
====第七题====================================
计算字符串中子串出现的位置，
例：子串"kk"在字符串abkkcdkkabkkefkk中出现的次数
思路:
1,既然是操作字符串就要先想到String类中是否提供相关方法.
2,可以先通过indexOf索引子串第一次出现的位置.第二次在索引的时候,就应该从第一次出现的位置+子串的长度后在从剩下的字符串中查找还有没有该子串.那么需要定义一个变量将剩下的字符串记录一下.
3,该过程既然重复.就需要循环来做.循环条件即为:当indexOf索引返回-1时.停止循环.
*/
public class Test7 {
    public static void main(String[] args) {
        String str = "kk";
        String s = "kk";
        System.out.println(findS(str, s));

    }

    private static int findS(String str, String s) {
        int count = 0;
        while (str.length() > 0) {
            int i = str.indexOf(s);
            if (i >= 0) {
                count++;
                str = str.substring(i + s.length(), str.length());
            }
        }
        return count;
    }
}
