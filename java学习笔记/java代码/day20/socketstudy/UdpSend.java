package socketstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 发送端
public class UdpSend {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 需要发送的数据
        String data = "hello, 我爱你，韩风烜";
        // 1、创建一个发送端的Socket
        DatagramSocket ds = null;
        try {
            // 端口被占用或者底层协议不对报出此异常
            ds = new DatagramSocket();
            // 2、创建datagramPackage对象
            byte[] buf = data.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("127.0.0.1"),
                    8888);
            // 3、发送数据包
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

    }

}
