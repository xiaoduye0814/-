package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
/*★★★★
====第四题====================================
编写一个程序，当用户输入一个目录时，
该程序能列出该目录下的所有子目录和文件。将目录和文件的绝对路径输出打印
思路：
1，获取用户输入的目录，封装成文件对象。
    a.获取输入可以有两种形式，一种通过System.in。另一种通过给主函数传值的形式。
    b.把输入的字符串封装成File对象。对其进行判断。该文件夹是否存在。
2，通过递归的形式列出目录所有文件夹和文件
    a.定义一个功能方法，遍历该文件夹对象，如果遍历到的File对象是文件夹就再次调用该功能方法（递归）；
*/
public class Test3 {
    public static void main(String[] args) {
        try {
            File targetFile = getFile();
            ArrayList<File> as = new ArrayList<File>();
            getListFile(targetFile, as);
            systemList(as);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void systemList(ArrayList<File> as) {
        for (File f : as) {
            System.out.println(f.getAbsolutePath());
        }
    }

    private static void getListFile(File targetFile, ArrayList<File> as) {
        File fs[] = targetFile.listFiles();
        if (fs == null) {
            return;
        }
        for (File f : fs) {
            if (f.isDirectory()) {
                getListFile(f, as);
            } else{
                as.add(f);
            }
        }
    }

    private static File getFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filaname = "";
        try {
            while (true) {
                filaname = br.readLine();
                File f = new File(filaname);
                break;
            }
        } finally {
            br.close();
        }
        return new File(filaname);
    }
}