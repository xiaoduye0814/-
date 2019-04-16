package baozhuang;

import java.io.IOException;
import java.io.Writer;

public class MyBufferedWriter extends Writer {

    private Writer w;

    private int pos = 0;

    private char[] buf = new char[1024];

    public MyBufferedWriter(Writer w) {
        this.w = w;
    }

    public void write(int ch) throws IOException {
        if (pos == 1024) {
            flush();
            pos = 0;
        }
        buf[pos++] = (char) ch;
    }

    public void write(String str) throws IOException {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            write(ch);
        }
    }

    public void newLine() throws IOException {
        write("\r\n");
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(buf[i]);
        }
    }

    @Override
    public void flush() throws IOException {
        w.write(buf, 0, pos);
    }

    @Override
    public void close() throws IOException {
        flush();
        w.close();
    }

}
