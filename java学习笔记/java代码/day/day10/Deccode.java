package day10;

public class Deccode {

    public static void main(String[] args) {
        System.out.println(decode("123中国人".getBytes(), 8));
    }

    static String decode(byte[] buf, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (buf[i] < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            len--;
        }
        String str = new String(buf, 0, len);
        return str;
    }
}
