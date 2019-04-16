package day10;

public class getMaxSubWithTwoStr {

    public static void main(String[] args) {
        System.out.println(getMaxSubWithTwoStr("ajsdgj", "sdg"));
    }

    static String getMaxSubWithTwoStr(String str1, String str2) {
        String longStr = str1.length() > str2.length() ? str1 : str2;
        String shortStr = str1.length() > str2.length() ? str2 : str1;
        for (int i = shortStr.length(); i > 0; i--) {
            for (int j = 0; j < shortStr.length() - i + 1; j++) {
                String subStr = shortStr.substring(j, j + i);
                if (longStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }
}
