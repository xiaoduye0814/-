package socketstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MySend {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));
            String line;
            while (true) {
                line = br.readLine();
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length,
                        InetAddress.getByName("127.0.0.1"), 7888);
                ds.send(dp);
                if ("bye".equals(line)) {
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }

}
