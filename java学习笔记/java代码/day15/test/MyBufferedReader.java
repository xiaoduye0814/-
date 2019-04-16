package test;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {

    private Reader r;

    public MyBufferedReader(Reader r) {
        this.r = r;
    }

    private char[] ch = new char[1024];

    // 可用的字符数量
    private int len;

    // 当前字符的角标
    private int pos;

    public int read() throws IOException {
        if(len == 0){
            len = r.read(ch);
            pos = 0;
        }
        if(len==-1){
            return -1;
        }
        len--;
        return ch[pos++];
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = read()) != -1) {
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                break;
            }
            sb = sb.append((char) ch);
        }
        if (ch == -1 && sb.length() == 0) {
            return null;
        } else {
            return sb.toString();
        }
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int count = 0;
        for(int i = off; i< off+len;i++){
            int ch = read();
            if (ch == -1) {
                break;
            }
            count++;
            cbuf[i] = (char) ch;
        }
        return count;
    }

    @Override
    public void close() throws IOException {
        r.close();
    }

}
