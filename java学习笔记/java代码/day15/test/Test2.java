package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ★★★ ====第三题==================================== 拷贝一个带内容的文件夹。
 * 1.copyDir方法，需要两个参数，被拷贝的文件夹source，想拷到哪去的文件夹target 2.在target下创建一个同名文件夹。
 * 3.遍历source下面的所有文件，存在两种情况 4.如果是文件夹，递归，将当前遍历的文件夹作为source，将target +
 * source.getName作为新的target 5.如果是标准文件。调用自定义的copyFile方法，用文件流包装一下来进行拷贝
 */

public class Test2 {

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
            File files[] = source.listFiles();
            if (files == null) {
                return;
            }
            for (File f : files) {
                copyDir(f, newDir);
            }
        } else {
            File newFile = new File(target, source.getName());
            newFile.createNewFile();
            copyFile(newFile, source);
        }
    }

    private static void copyFile(File newFile, File source) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            try {
                bis = new BufferedInputStream(new FileInputStream(source));
                bos = new BufferedOutputStream(new FileOutputStream(newFile));
                int ch;
                while ((ch = bis.read()) != -1) {
                    bos.write(ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                CloseUtils.close(bis, bos, null, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
