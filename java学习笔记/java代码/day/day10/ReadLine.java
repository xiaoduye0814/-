package day10;

import java.io.IOException;

public class ReadLine {

    public static void main(String[] args) throws IOException {
        while (true) {
            String sb = readLine();
            System.out.println(sb);
            if ("bye".equals(sb)) {
                break;
            }
        }
    }

    static String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int ch = System.in.read();
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                break;
            }
            sb.append((char) ch);
        }
        return sb.toString();
    }
}
