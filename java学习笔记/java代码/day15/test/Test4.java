package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 输出树结构
 * @author Administrator
 *
 */
public class Test4 {

    public static void main(String[] args) {
        File file = new File("E:/source");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("day15/b.txt"));
            getTreelist(file, bw, 0);
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

    private static void getTreelist(File file, BufferedWriter bw, int i) throws IOException {
        bw.write(getHead(i) + file.getName());
        bw.newLine();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                getTreelist(f, bw, i + 1);
            }
        }
    }

    private static String getHead(int tar) {
        String str = "|--";
        for (int i = 0; i < tar; i++) {
            str += "---";
        }
        return str;
    }

}
