package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Test20 {

    /**
     * /*★★★
    ====第二十题==================================


    将一个图片切割成多个文件。在将多个文件合并成该图片


    1，通过字节流读取该图片。定义一个缓冲区数组该数组的大小 是要生成的切割后的文件大小。
    通过输出流将该数组中的数据，写到一个文件中（文件名要有规律。1.haha  2.haha...）
    （可以通过一个自定义配置文件保存原文件的基本属性信息。如：源文件的名字 已经切割出来的碎片文件的个数。方便合并。）

    2,合并，首先要知道碎片文件的目录，列出该目录当前的所有.haha文件。（遍历时可以通过配置文件中的信息确定循环的次数。）
    并按照顺序把每一个碎片文件用流读取。（一个文件对应一个流。）
    将这些流存入集合。（why？因为要通过序列流进行合并。（SequenceInputStream）该流会接受一个Enumeration）

    3，读取序列流中的数据，并把该数据都写入到一个（图片）文件中。
    */
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int num = 1;
        try {
            bis = new BufferedInputStream(new FileInputStream("day15/a.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("day15/a1.jpg"));
            byte[] but = new byte[1024];
            int count = 0;
            int ch;
            while ((ch = bis.read(but)) != -1) {
                if (count == 10) {
                    count = 0;
                    bos.close();
                    bos = new BufferedOutputStream(new FileOutputStream(
                            "day15/a" + (++num) + ".jpg"));
                }
                count++;
                bos.write(but, 0, ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Vector<InputStream> v = new Vector<InputStream>();
            BufferedOutputStream bo = null;
            SequenceInputStream sis = null;
            try {
                bo = new BufferedOutputStream(new FileOutputStream(
                        "day15/aa.jpg"));
                for (int i = 0; i < num; i++) {
                    v.add(new FileInputStream("day15/a" + (i + 1) + ".jpg"));
                }
                Enumeration<InputStream> e = v.elements();
                sis = new SequenceInputStream(e);
                int ch;
                while ((ch = sis.read()) != -1) {
                    bo.write(ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bis.close();
                    sis.close();
                    bos.close();
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
