package readerandwrrter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("day13/a.txt");
            /*
             * int c; while ((c = fr.read()) != -1) { char ch = (char) c;
             * System.out.print(ch); }
             */
            char[] buf = new char[4];
            int num;
            while ((num = fr.read(buf)) != -1) {
                String data = new String(buf, 0, num);
                System.out.print(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
