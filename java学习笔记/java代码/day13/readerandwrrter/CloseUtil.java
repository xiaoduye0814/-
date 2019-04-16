package readerandwrrter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CloseUtil {
    public static void closeUtil(Reader fis, Writer fos) throws IOException {
        try {
            if (fis != null) {
                fis.close();
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}