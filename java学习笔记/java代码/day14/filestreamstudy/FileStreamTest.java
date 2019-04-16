package filestreamstudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("day14/1.jpg");
            fos = new FileOutputStream("day14/2.jpg");
            /*
             * int ch; while ((ch = fis.read()) != -1) { fos.write(ch); }
             */
            byte[] byt = new byte[1024];
            int len;
            while ((len = fis.read(byt)) != -1) {
                fos.write(byt, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtil.close(fis, fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
