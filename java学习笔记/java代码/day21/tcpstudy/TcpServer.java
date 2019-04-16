package tcpstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    /**
     * TCP服务器端
     */
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            // 创建服务器端ServerSocket,监听端口
            ss = new ServerSocket(8881);
            // 等待客户端的连接，获取客户端的Socket
            Socket sock = ss.accept();
            // 获得输入输出流
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            // 发送欢迎语
            out.write("连接成功，欢迎光临本站".getBytes());
            // 接受客户端反馈的数据
            /*
             * byte[] buf = new byte[1024]; int len = in.read(buf);
             * System.out.println(new String(buf, 0, len));
             */
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while (true) {
                line = br.readLine();
                System.out.println(line);
                if ("quit".equals(line)) {
                    break;
                }
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
