package baozhuang;

import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {
    private Reader r;

    private char[] c = new char[1024];

    private int pos;

    private int len;

    public MyBufferedReader(Reader r) {
        this.r = r;
    }

    /**
     * 实现read方法
     * @throws IOException 
     */
    public int read() throws IOException {
        if (len == 0) {
            len = r.read(c);
            pos = 0;
        }
        if (len == -1) {
            return -1;
        }
        len--;
        return c[pos++];
    }

    /**
     * 实现readLine方法
     * @throws IOException 
     */
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

    /**
     * close方法
     * @throws IOException 
     */
    public void close() throws IOException {
        r.close();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int count = 0;
        for (int i = off; i < len + off; i++) {
            int ch = read();
            if (ch == -1)
                break;
            count++;
            cbuf[i] = (char) ch;
        }
        return count;
    }
}
