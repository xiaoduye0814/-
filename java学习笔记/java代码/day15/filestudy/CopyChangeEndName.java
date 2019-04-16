package filestudy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyChangeEndName {

    public static void main(String[] args) {
        File source = new File("E:/source");
        File target = new File("E:/target");
        try {
            copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        if (source.isDirectory()) {
            File files[] = source.listFiles();
            if (files == null) {
                return;
            }
            for (File file : files) {
                copyFile(file, target);
            }
        }
        if (source.isFile()) {
            if (source.getName().endsWith(".java")) {
                String filename = source.getName().replace(".java", ".jad");
                File newFile = new File(target, filename);
                newFile.createNewFile();
                copyFileByIO(source, newFile);
            }
        }
    }

    private static void copyFileByIO(File source, File newFile) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(source));
            bos = new BufferedOutputStream(new FileOutputStream(newFile));
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
