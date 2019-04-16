package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * /*★★★★★
====第六题====================================
取出D:盘下全部的.java文件的文件路径保存在java.txt文件中

思路:
1.通过递归的方式遍历d:盘.判断文件的扩展名是否是以.java结尾.
2,把符合条件的File对象都存入到集合中.
3,遍历该集合.通过输出流把文件对象的getAbsolutePath写入到java.txt文件中.
(不存入集合直接写是可以的,但最好临时存储一下.这样就可以对所有的.java文件进行更多的其他操作.)
*/
public class Test6 {
    public static void main(String[] args) {
        File file = new File("E:/source");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("day15/b.txt"));
            writeTxt(file, bw);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void writeTxt(File file, BufferedWriter bw) throws IOException {
//        File files[] = file.listFiles();
//        for (File f : files) {
//            if (f.isDirectory()) {
//                writeTxt(f, bw);
//            } else if (f.isFile() && f.getName().endsWith(".java")) {
//                bw.write(f.getAbsolutePath());
//                bw.newLine();
//            }
//        }
    
        if(file.isDirectory()){
            File files[] = file.listFiles();
            for (File f : files) {
                writeTxt(f, bw);
            }
        }
        if (file.isFile() && file.getName().endsWith(".java")) {
            bw.write(file.getAbsolutePath());
            bw.newLine();
        }
    }
}
