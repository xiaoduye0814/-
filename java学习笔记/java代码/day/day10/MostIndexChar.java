package day10;

public class MostIndexChar {

    public static void main(String[] args) {
        System.out.print("出现次数最多的是");
        for (String str : getMostTimesChar("111fdtgaaaaaaaaaaa")) {
            System.out.print(str + "....");
        }
    }

    static String[] getMostTimesChar(String str) {
        int count = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder();
        String[] strArr = str.split("");
        for (int i = 0; i < strArr.length; i++) {
            String[] orderStr = str.split("");
            if (str.contains(strArr[i])) {
                str = str.replace(strArr[i], "");
                count = orderStr.length - 1 - str.length();
                if (count >= max) {
                    max = count;
                    sb.append(strArr[i] + ",");
                }
            }
        }
        String s[] = sb.toString().split(",");
        return s;
    }
}
