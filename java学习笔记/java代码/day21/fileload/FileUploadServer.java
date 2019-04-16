package fileload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {

    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5656);
            while (true) {
                Socket sock = ss.accept();
                new Thread(new FileUploadService(sock)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
