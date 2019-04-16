package iootherstudy;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("day16/1.txt");
        int num = 98;
        String s = "aa";
        pw.write(s);
        pw.write(num);
        pw.print(num);
        pw.close();

        PrintStream ps = new PrintStream("day16/2.txt");
        ps.write(num);
        ps.print(num);
        ps.close();
    }
}
