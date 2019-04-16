package filestreamstudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import baozhuang.MyBufferedInputStream;
import baozhuang.MyBufferedOutputStream;

public class BufferedStreamTest {

    public static void main(String[] args) {
        MyBufferedInputStream bis = null;
        MyBufferedOutputStream bos = null;
        try {
            bis = new MyBufferedInputStream(new FileInputStream("day14/1.jpg"));
            bos = new MyBufferedOutputStream(
                    new FileOutputStream("day14/2.jpg"));
            /*
             * int ch; while ((ch = bis.read()) != -1) { bos.write(ch); }
             */
            byte[] but = new byte[1024];
            int len;
            while ((len = bis.read(but)) != -1) {
                bos.write(but, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtil.close(bis, bos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
