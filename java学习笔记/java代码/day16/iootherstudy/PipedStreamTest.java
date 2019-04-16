package iootherstudy;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);
        pos.write("欢迎访问本网站~~~~".getBytes());
        int len = pis.available();
        byte[] but = new byte[len];
        pis.read(but);
        System.out.println(new String(but));
        pis.close();
        pos.close();

    }

}
