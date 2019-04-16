package socketstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //1、创建Socket
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
            // 准备数据包
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            // 3、接受数据包
            ds.receive(dp);
            // 4、查看数据包中收到的数据
            byte[] buf1 = dp.getData();
            int len = dp.getLength();
            String data = new String(buf1, 0, len);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }

}
