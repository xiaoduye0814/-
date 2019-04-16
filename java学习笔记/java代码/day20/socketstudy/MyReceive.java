package socketstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyReceive {

    /**
     * @param args
     * @throws SocketException 
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(7888);
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        while (true) {
            ds.receive(dp);
            byte buf[] = dp.getData();
            int len = dp.getLength();
            String ipStr = dp.getAddress().getHostAddress() + "("
                    + dp.getAddress().getHostName() + ")";
            int port = dp.getPort();
            String data = new String(buf, 0, len);
            System.out.println(data + "~~~~~~from" + ipStr + ":" + port);
            if ("bye".equals(data)) {
                break;
            }
        }
        ds.close();
    }

}
