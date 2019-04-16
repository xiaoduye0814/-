package iootherstudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SequenceInputStreamTest {

    public static void main(String[] args) throws IOException {
        InputStream in1 = new FileInputStream("day16/1.txt");
        InputStream in2 = new FileInputStream("day16/2.txt");
        InputStream in3 = new FileInputStream("day16/all.txt");
        OutputStream out = new FileOutputStream("day16/allFile.txt");
        /**
         * 两个输入流
         */
        //        SequenceInputStream sis = new SequenceInputStream(in1,
        //                new SequenceInputStream(in2, in3));

        /**
         * 多个输入流
         */
        //        Vector<InputStream> v = new Vector<InputStream>();
        //        v.add(in1);
        //        v.add(in2);
        //        v.add(in3);
        //        Enumeration<InputStream> e = v.elements();
        //        SequenceInputStream sis = new SequenceInputStream(e);

        /**
         * ArrayList实现
         */
        ArrayList<InputStream> as = new ArrayList<InputStream>();
        as.add(in1);
        as.add(in2);
        as.add(in3);
        final Iterator<InputStream> iter = as.iterator();
        SequenceInputStream sis = new SequenceInputStream(
                new Enumeration<InputStream>() {

                    @Override
                    public boolean hasMoreElements() {
                        return iter.hasNext();
                    }

                    @Override
                    public InputStream nextElement() {
                        return iter.next();
                    }
                });

        int ch;
        while ((ch = sis.read()) != -1) {
            out.write(ch);
        }
        sis.close();
        out.close();
    }
}
