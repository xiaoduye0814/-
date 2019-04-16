package abstractclassstudy;

/**
 * 模板使用
 * @author Administrator
 *
 */

abstract class AbstractClass {
    abstract void open();

    abstract void print();

    abstract void close();

    public final void run() {
        open();
        print();
        close();
    }
}

class PrintClass extends AbstractClass {

    private String data;

    public PrintClass(String data) {
        this.data = data;
    }

    public void open() {
        System.out.print("<<");
    }

    public void print() {
        System.out.print(data);
    }

    public void close() {
        System.out.print(">>");
    }
}

public class UseModel {
    public static void main(String[] args) {
        PrintClass p = new PrintClass("学习模板");
        p.run();
    }
}
