package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Test1 {

    /**
     * 将图片分成若干份，每10k一个文件，之后用序列流合并成一个图片
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day16/a.jpg");
        FileOutputStream fos = new FileOutputStream("day16/a1.jpg");
        byte[] buf = new byte[1024];
        int ch;
        int count = 0;
        int num = 1;
        try{
            while ((ch = fis.read(buf)) != -1) {
                if (count == 10) {
                    count = 0;
                    fos.close();
                    fos = new FileOutputStream("day16/a" + (++num) + ".jpg");
                }
                fos.write(buf, 0, ch);
                count++;
            }
        } finally {
            fis.close();
            fos.close();
        }
        Vector<InputStream> v = new Vector<InputStream>();
        for(int i = 0;i<num;i++){
            InputStream in = new FileInputStream("day16/a" + (i + 1) + ".jpg");
            v.add(in);
        }
        Enumeration<InputStream> es = v.elements();
        SequenceInputStream sis = new SequenceInputStream(es);
        OutputStream out = new FileOutputStream("day16/fianl.jpg");
        int chN;
        try {
            while ((chN = sis.read()) != -1) {
                out.write(chN);
            }
        } finally {
            sis.close();
            out.close();
        }
    }
}
