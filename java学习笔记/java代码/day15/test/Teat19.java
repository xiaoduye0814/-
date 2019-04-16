package test;

import java.util.LinkedList;

public class Teat19 {
    public static void main(String[] args) {
        DuiLie dl = new DuiLie();
        dl.myAdd("hahah");
        dl.myAdd("kkkk");
        dl.myAdd("qqq");
        while (!dl.isNull()) {
            System.out.println(dl.myGet());
        }
    }
}

/*
 * ★★ ====第十九题================================== 利用LinkedList去实现一个队列的效果.
 * 自定该功能类.(队列的特点是元素先进先出,去查看LinkList中的方法)
 */
class DuiLie<T> {
    private LinkedList<T> ll;

    DuiLie() {
        ll = new LinkedList<T>();
    }

    public void myAdd(T t) {
        ll.addFirst(t);
    }

    public T myGet() {
        return ll.removeLast();
    }

    public boolean isNull() {
        return ll.isEmpty();
    }
}
