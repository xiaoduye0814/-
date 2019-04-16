package baozhuang;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import readerandwrrter.CloseUtil;

public class LineNumberReaderTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AllLineNumberAndBufferedReader lnb = null;
        BufferedWriter bw = null;
        try {
            lnb = new AllLineNumberAndBufferedReader(new FileReader(
                    "day13/1.txt"));
            bw = new BufferedWriter(new FileWriter("day13/2.txt"));
            String str = "";
            lnb.setLineNumber(900);
            while ((str = lnb.readLine()) != null) {
                int lineNum = lnb.getLineNumber();
                bw.write(lineNum + " : " + str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtil.closeUtil(lnb, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
