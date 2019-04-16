package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
/*★★★★
====第十二题==================================
写一个程序，允许用户依次输入多个姓名和住址，
并能将用户的输入保存到文件中。
用户输入 ”quit” 表示输入完毕，程序退出。
*/
public class Test12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("day15/b.txt"));
        try {
            while (true) {
                String str = br.readLine();
                if ("quit".equals(str)) {
                    break;
                }
                bw.write(str);
                bw.newLine();
            }
        } finally {
            br.close();
            bw.close();
        }

    }
}
