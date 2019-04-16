package test;

import java.util.Enumeration;
import java.util.TreeSet;
import java.util.Vector;

/**
 * /*★★
====第二十一题==================================
编写一个方法。去除Vector集合中的重复元素。
思路：
1，自定义一个Vector集合。对原有的Vector集合进行迭代。
把迭代出来的元素存入到新集合中。在存的时候进行判断新的集合中是否有该元素。‘
如果有，就不要进行存储。
迭代完成 。新的Vector集合中就不存在重复元素了。
*/
public class Test21 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>();
        TreeSet<String> ts = new TreeSet<String>();
        v.add("aasd");
        v.add("aasd");
        v.add("saf");
        v.add("sdfsdf");
        v.add("sdfsd");
        Enumeration<String> enume = v.elements();
        while (enume.hasMoreElements()) {
            ts.add(enume.nextElement());
        }
        v = new Vector<String>();
        for (String str : ts) {
            v.add(str);
        }
        for (String str : v) {
            System.out.print(str + "  ");
        }
    }
}
