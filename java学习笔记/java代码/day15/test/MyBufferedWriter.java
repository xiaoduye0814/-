package test;

import java.io.IOException;
import java.io.Writer;

public class MyBufferedWriter extends Writer {
    private Writer w;

    public MyBufferedWriter(Writer w) {
        this.w = w;
    }

    private char[] buf = new char[1024];

    private int pos;

    public void write(int ch) throws IOException {
        if (pos == 1024) {
            this.flush();
            pos = 0;
        }
        buf[pos++] = (char) ch;
    }

    public void write(String str) throws IOException {
        char[] c = str.toCharArray();
        for (char cha : c) {
            this.write(cha);
        }
    }
    
    public void newLine() throws IOException {
        this.write("\r\n");
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            this.write(buf[i]);
        }
    }

    @Override
    public void flush() throws IOException {
        w.write(buf, 0, pos);
    }

    @Override
    public void close() throws IOException {
        this.flush();
        w.close();
    }

}
