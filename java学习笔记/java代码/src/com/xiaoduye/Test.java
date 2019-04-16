package com.xiaoduye;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(1);
        Iterator<Integer> iter = list.iterator();
        Iterator<Integer> iter1 = list.iterator();
        while (iter1.hasNext()) { //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
            System.out.println(iter1.next());
        }
        while (iter.hasNext()) {
            if (iter.next() == 1) {
                iter.remove();
            }
        }

}
}
