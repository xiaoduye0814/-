package readerandwrrter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("day13/1.txt");
            fw = new FileWriter("day13/3.txt");
            char[] ch = new char[1024];
            int len;
            while ((len = fr.read(ch)) != -1) {
                /*
                 * String str = new String(ch, 0, len); fw.write(str);
                 */
                fw.write(ch, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                CloseUtil.closeUtil(fr, fw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

