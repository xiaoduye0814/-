package day11;

import java.util.Enumeration;
import java.util.Vector;

public class ArrayListTest {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(".");
        v.add("1");
        v.add("11");
        v.add("111");
        v.add("1111");
        Enumeration enu = v.elements();
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
    }
}