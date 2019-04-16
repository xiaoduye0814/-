package filestudy;

import java.io.File;

public class DeleteDir {
    public static void main(String[] args) {
        File file = new File("e:/target");
        deleteDir(file);
    }

    private static void deleteDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteDir(f);
            }
        }
        file.delete();
    }
}
