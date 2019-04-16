package com.xiaoduye;

/**
 * \\u转中文
 * @author Administrator
 *
 */
public class ChineseCharacterTransform {
    public static void main(String[] args) {
        String str = "U字符";
        String Ustr = to_U_Str(str);
        //        System.out.println(Ustr); // 转化为U字符

        Ustr = "#hibernate\u7684\u76f8\u5173\u914d\u7f6e";
        System.out.println(UStr_2_Str(Ustr)); // 转化为表示的文本
    }

    /* 将字符串转化为\\u形式的字符串，如： "U字符" -> "\\u55\\u5b57\\u7b26" ;U字符为字符串中每个字符的16进制信息 */
    public static String to_U_Str(String str) {
        String tmp = "";

        for (char C : str.toCharArray())
            // 获取所有字符
            tmp += "\\u" + Integer.toHexString(C); // 将每个字符的的值，转化为16进制字符串

        return tmp;
    }

    /* 将U字符转化为其表示的字符串, 如： "\\u55\\u5b57\\u7b26" -> "U字符" ;按\\u分割，依次转化为对应字符 */
    public static String UStr_2_Str(String Ustr0) {
        String Ustr = Ustr0;

        int S = 0, E = 0;
        String C = "", Value = "";

        while (Ustr.contains("\\u")) {
            S = Ustr.indexOf("\\u") + "\\u".length();
            E = Ustr.indexOf("\\u", S);
            if (E == -1)
                E = Ustr.length();

            if (E > S) {
                C = Ustr.substring(S, E);
                if (C.length() > 4)
                    C = C.substring(0, 4);
                Value = (char) Integer.parseInt(C, 16) + "";

                Ustr = Ustr.replace("\\u" + C, Value);
            }
        }

        return Ustr;
    }
}
