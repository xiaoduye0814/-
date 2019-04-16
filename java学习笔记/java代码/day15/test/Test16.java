package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
/*★★★
====第十六题==================================
已知文件a.txt文件中的内容为“bcdeadferwplkou”，
请编写程序读取该文件内容，并按照自然顺序排序后输出到b.txt文件中。
即b.txt中的文件内容应为“abcd…………..”这样的顺序。
思路：
1，将该文件读取将数据取出，变成字符串
    a.因为是文本文件。可以直接用字符流（FileReader）
    b.为了提高效率，并方便获取数据。对其进行包装（BufferedReader）使用readLine方法一行一行读。
2，把字符串变成字符数组，对该数组进行排序。
    a.通过字符创的toCharArray方法，将字符串变成字符数组。
    b.自定义排序功能函数（冒泡，选择都可以）对字符数组进行排序。
3，把排序后的数组变成字符串，并通过流将字符串写入b.txt文件中。
    a.通过String类的构造函数将字符数组变成字符串。
    b.通过FileWriter把字符串写入到b.txt文件中。
*/
public class Test16 {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("day15/a.txt"));
            bw = new BufferedWriter(new FileWriter("day15/b.txt"));
            String str;
            while ((str = br.readLine()) != null) {
                String[] s = str.split("");
                Arrays.sort(s);
                StringBuilder sb = new StringBuilder();
                for (String ss : s) {
                    sb = sb.append(ss);
                }
                bw.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
