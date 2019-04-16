package iootherstudy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ByteArrayStream {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        /**
         * 从内存缓冲数组读取数据
         */
        byte[] but = "中国".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(but);
        int len = bais.available();
        byte[] buffer = new byte[len];
        bais.read(buffer);
        String str = new String(buffer);
        System.out.println(str);

        /**
         * 往内存中写数据
         */
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.out.println("baos.size()" + baos.size());
        baos.write("中国人国好啊".getBytes());
        System.out.println("baos.size()" + baos.size());
        byte[] buta = baos.toByteArray();
        System.out.println("buta.length" + buta.length);
        System.out.println(new String(buta));

        /**
         * 结合数据格式化使用
         */
        DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());
        dos.write(98);
    }

}
