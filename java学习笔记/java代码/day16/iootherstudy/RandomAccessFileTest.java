package iootherstudy;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    /**
     * 软件30次到期，提示
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        RandomAccessFile raf = new RandomAccessFile("day16/a.txt", "rw");
       /**
        * 第一种
        */
        /* 
        int count = Integer.parseInt(raf.readLine());
        if (count == 30) {
            System.out.println("过期~~~~");
            return;
        }
        count++;
        System.out.println("第" + count + "次使用");
        raf.seek(0);
        raf.write(String.valueOf(count).getBytes());
        raf.close();
        */
        
        /**
         * 第二种
         */
        // 首先写入格式化数据0
        //        raf.writeInt(0);
        int count = raf.readInt();
        if (count > 5) {
            System.out.println("过期");
            return;
        }
        count++;
        System.out.println("第" + count);
        raf.seek(0);
        raf.writeInt(count);
        raf.close();
    }

}
