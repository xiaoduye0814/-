package baozhuang;

import java.io.IOException;
import java.io.OutputStream;

public class MyBufferedOutputStream extends OutputStream {

    private OutputStream out;

    private int pos;

    private byte[] but = new byte[1024];

    public MyBufferedOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        if (pos == 1024) {
            flush();
            pos = 0;
        }
        but[pos++] = (byte) b;
    }

    public void close() throws IOException {
            flush();
            out.close();
    }

    public void flush() throws IOException {
        out.write(but, 0, pos);
    }

}
