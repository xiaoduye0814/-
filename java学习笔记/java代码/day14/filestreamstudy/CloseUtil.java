package filestreamstudy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CloseUtil {
    private CloseUtil() {
    };

    public static void close(InputStream in, OutputStream out) throws IOException {
        try{
            if(in != null)
                in.close();
        } finally {
            if (out != null)
                out.close();
        }
    }
}
