package file;

import java.io.File;


public class CreateFile {

    public static void main(String[] args) {
        File file = new File("D:\\test");
        System.out.println(getDirSize(file));
    }

    static long size = 0;
    public static Long getDirSize(File file) {
        if (file.isFile()) {
            size += file.length();
        } else if (file.isDirectory()) {
            File[] fi = file.listFiles();
            for (int i = 0; i < fi.length; i++) {
                getDirSize(fi[i]);
            }
        }
        return size;
    }
}
