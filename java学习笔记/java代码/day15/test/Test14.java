package test;

/**
 * /*★★★★
====第十四题==================================
给定两个字符串，比较两个字符串中最大相同的子串.
*/
public class Test14 {

    public static void main(String[] args) {
        String s1 = "asdsfkjhfahajshd";
        String s2 = "dsfdfkjh";
        String str = compareStr(s1, s2);
        System.out.println(str);
    }

    private static String compareStr(String s1, String s2) {
        String str1 = (s1.length() > s2.length()) ? s1 : s2;
        String str2 = (s1.length() > s2.length()) ? s2 : s1;
        String sub = null;
        for (int i = str2.length(); i > 0; i--) {
            for (int j = 0; j < str2.length() - i + 1; j++) {
                sub = str2.substring(j, j + i);
            }
            if (str1.contains(sub)) {
                return sub;
            }
        }
        return sub;
    }
}
