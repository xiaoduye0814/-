package myserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(9999);
            System.out.println("服务器正在启动...");
            while (true) {
                Socket sock = ss.accept();
                System.out.println("开始访问啦"
                        + sock.getInetAddress().getHostAddress());
                new Thread(new MyService(sock)).start();
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
