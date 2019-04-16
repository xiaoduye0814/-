package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class CloseUtils {

    public static void close(InputStream in, OutputStream out, Reader r,
            Writer w) throws IOException {
        try {
            if (in != null) {
                in.close();
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } finally {
                try {
                    if (r != null) {
                        r.close();
                    }
                } finally {
                    if (w != null) {
                        w.close();
                    }
                }
            }
        }
    }
}
