package tcpstudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpClient {

    /**
     * 客户端程序
     */
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            // 创建客户端socket，并尝试进行连接
            socket = new Socket("127.0.0.1", 8881);
            // 获得输入输出流
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            // 接受欢迎语
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            System.out.println(new String(buf, 0, len));
            // 向服务器发送语言
            //            out.write("hello,我叫付佳".getBytes());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            String line;
            while (true) {
                line = br.readLine();
                //                out.write((line + "\r\n").getBytes());
                // 或者这样写
                bw.write(line);
                bw.newLine();
                bw.flush();
                if ("quit".equals(line)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
