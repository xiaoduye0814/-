package readerandwrrter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("day13/2.txt", true);
            fw.write("hasdgald");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
