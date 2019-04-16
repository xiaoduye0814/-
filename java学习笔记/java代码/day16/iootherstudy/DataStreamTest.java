package iootherstudy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(
                "day16/a.txt"));
        int num = 98;
        String str = "abc中国人";
        //        dos.write(num);
        dos.writeUTF(str);
        dos.writeInt(num);
        dos.close();
        DataInputStream dis = new DataInputStream(new FileInputStream(
                "day16/a.txt"));
        //        int numNow = dis.readInt();
        //        System.out.println(numNow);
        String s = dis.readUTF();
        System.out.println(s);
    }
}
