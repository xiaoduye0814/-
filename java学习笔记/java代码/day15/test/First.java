package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
/*★
====第二题====================================
自定义字符输入流的包装类，通过这个包装类对底层字符输入流进行包装，
让程序通过这个包装类读取某个文本文件（例如，一个java源文件）时，
能够在读取的每行前面都加上有行号和冒号。 
提示:（MyBufferedReader,MyLineNumberReader）
*/
public class First {
    public static void main(String[] args) {
        MyLineNumberReader mlnr = null;
        MyBufferedWriter bw = null;
        try {
            mlnr = new MyLineNumberReader(new FileReader("day15/a.txt"));
            bw = new MyBufferedWriter(new FileWriter("day15/b.txt"));
            mlnr.setLineNumber(100);
            String str;
            while ((str = mlnr.readLine()) != null) {
                bw.write(mlnr.getLineNumber() + " : " + str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtils.close(null, null, mlnr, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
