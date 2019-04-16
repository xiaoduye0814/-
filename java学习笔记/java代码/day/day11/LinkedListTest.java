package day11;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 7个小孩，循环数3，谁数到3谁出列,求最后剩下的小孩子
 * @author Administrator
 *
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Boy> linkedList1 = new LinkedList<Boy>();
        linkedList1.add(new Boy("孩子1"));
        linkedList1.add(new Boy("孩子2"));
        linkedList1.add(new Boy("孩子3"));
        linkedList1.add(new Boy("孩子4"));
        linkedList1.add(new Boy("孩子5"));
        linkedList1.add(new Boy("孩子6"));
        linkedList1.add(new Boy("孩子7"));
        Iterator<Boy> iter = linkedList1.iterator();
        int count = 0;
        while (linkedList1.size() > 1) {
            Boy boy = iter.next();
            count++;
            if (count % 3 == 0) {
                System.out.println(boy + "出列");
                iter.remove();
            }
            if (!iter.hasNext())
                iter = linkedList1.iterator();
        }
        System.out.println("幸运儿是：" + linkedList1.get(0));
    }
}

class Boy{
    private String name;

    public Boy(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}