package myserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyService implements Runnable {
    private Socket sock;

    public MyService(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try {
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            out.write("你好，欢迎光临本小站，你已经成功登陆".getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            while (true) {
                bw.write(br.readLine().toUpperCase());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
