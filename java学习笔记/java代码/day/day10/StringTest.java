package day10;

import java.io.UnsupportedEncodingException;

public class StringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        getIndex("had124324dgfdaagbfgfhad", "aasfdretfgergd");
    }

    static void getIndex(String str, String subStr) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        for (int i = 0; i <= pos; i++) {
            pos = str.indexOf(subStr, pos);
            if (pos == -1) {
                break;
            }
            sb.append(pos + ",");
            pos = pos + subStr.length();
        }

        String s = sb.toString();
        if (s.length() == 0) {
            System.out.println("没有你要查找的数据");
            return;
        }
        String strArr[] = s.split(",");
        int[] orderNum = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                orderNum[i] = Integer.valueOf(strArr[i]);
            }
            for (int a : orderNum) {
                System.out.print(a + ",");
            }
    }
}
