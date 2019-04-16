package baozhuang;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream extends InputStream {

    private InputStream in;

    private byte[] but = new byte[1024];

    private int len;

    private int pos;

    public MyBufferedInputStream(InputStream in) {
        this.in = in;
    }

    public void close() throws IOException {
        in.close();
    }

    @Override
    public int read() throws IOException {
        if (len == 0) {
            len = in.read(but);
            pos = 0;
        }
        if (len == -1) {
            return -1;
        }
        len--;
        return but[pos++] & 0xff;//buf[pos++]&0xff
    }
}
