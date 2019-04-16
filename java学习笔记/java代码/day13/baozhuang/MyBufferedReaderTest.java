package baozhuang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import readerandwrrter.CloseUtil;

public class MyBufferedReaderTest {

    public static void main(String[] args) {
        AllLineNumberAndBufferedReader mbr = null;
        MyBufferedWriter bw = null;
        try {
            mbr = new AllLineNumberAndBufferedReader(new FileReader(
                    "day13/1.txt"));
            bw = new MyBufferedWriter(new FileWriter("day13/2.txt"));
            //            int ch;
            //            while ((ch = mbr.read()) != -1) {
            //                bw.write(ch);
            //            }
            String str;
            while ((str = mbr.readLine()) != null) {
                bw.write(str);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtil.closeUtil(mbr, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
