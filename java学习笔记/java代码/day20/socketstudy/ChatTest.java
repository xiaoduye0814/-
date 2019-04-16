package socketstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatTest {
    /**
     * 多线程实现聊天
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        new Thread(new ChatReceive()).start();
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            line = br.readLine();
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("127.0.0.1"), 6666);
            ds.send(dp);
            if ("bye".equals(line))
                break;
        }
        br.close();
        ds.close();
    }
}

class ChatReceive implements Runnable {
    public void run() {
        //实现接收端
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(6666);
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                ds.receive(dp);
                String data = new String(dp.getData(), 0, dp.getLength());
                String ipStr = dp.getAddress().getHostAddress() + ":"
                        + dp.getPort();
                System.out.println(data + " from " + ipStr);
                if ("bye".equals(data))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null)
                ds.close();
        }
    }
}