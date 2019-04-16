package test;

public class Test0 {

    public static void main(String[] args) {
        String str = "ahsdkahefdoiwejo";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] > ch[j]) {
                    char pos = ch[i];
                    ch[i] = ch[j];
                    ch[j] = pos;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
