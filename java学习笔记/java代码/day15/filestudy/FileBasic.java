package filestudy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileBasic {

    public static void main(String[] args) {
        File file = new File("E:\\delete");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("day15/a.txt"));
            listAllFiles(file, bw, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listAllFiles(File file, BufferedWriter bw, int i) throws IOException {
            bw.write(getOrder(i) + file.getName());
            bw.newLine();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                    listAllFiles(f, bw, i + 1);
            }
        }
    }

    private static String getOrder(int order) {
        String listStr = "|-";
        for (int i = 0; i < order; i++) {
            listStr += "--";
        }
        return listStr;
    }

}

class MyFileNameFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        if (name.endsWith(".java"))
            return true;
        return false;
    }
}
