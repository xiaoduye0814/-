package filestudy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileTest {

    public static void main(String[] args) {
        try {
            File file = getFileModel();
            ArrayList<File> as = new ArrayList<File>();
            getAttayListFileName(file, as);
            systemOutFileName(as);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void systemOutFileName(ArrayList<File> as) {
        for (File f : as) {
            System.out.println(f.getName());
        }
    }

    private static void getAttayListFileName(File file, ArrayList<File> as) {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                getAttayListFileName(f, as);
            } else if (f.getName().endsWith(".java")) {
                as.add(f);
            }
        }
    }

    private static File getFileModel() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入文件名称：");
        String filename = "";
        while (true) {
            filename = br.readLine();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("无此文件。");
                continue;
            }
            if (!file.isDirectory()) {
                System.out.println("文件不是目录。");
                continue;
            }
            break;
        }
        return new File(filename);
    }
}
