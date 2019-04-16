package filestudy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDir {

    public static void main(String[] args) {
        File source = new File("E:/source");
        File target = new File("E:/target");
        try {
            copyDir(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDir(File source, File target) throws IOException {
        if (source.isDirectory()) {
            File newDir = new File(target, source.getName());
            newDir.mkdir();
            File[] files = source.listFiles();
            for (File file : files) {
                copyDir(file, newDir);
            }
        } else if (source.isFile()) {
            copyFile(source, target);
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        File newFile = new File(target, source.getName());
        newFile.createNewFile();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(
                source));
            bos = new BufferedOutputStream(
                new FileOutputStream(newFile));
            int ch;
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } finally {
                if (bos != null) {
                    bos.close();
                }
            }
        }
    }
}
