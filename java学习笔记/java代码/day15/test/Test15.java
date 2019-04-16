package test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test15 {

    /*
     * ★★★ ====第十五题==================================
     * 编写一个程序，记录该程序运行次数。运行满足30次，就提示用户“软件试用期限已到”；
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("day15/a.txt", "rw");
        //        raf.writeInt(0);
        int count = raf.readInt();
        if (count > 5) {
            System.out.println("过了");
            return;
        }
        count++;
        System.out.println(count);
        raf.seek(0);
        raf.writeInt(count);
        raf.close();
    }

}
