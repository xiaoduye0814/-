package abstractclassstudy;

/**
 * 模板使用2,声明方法的使用顺序，并且生命为final
 * @author Administrator
 *
 */
abstract class AbstractPrint {
    abstract void open();

    abstract void print();

    abstract void close();

    public final void run() {
        open();
        print();
        close();
    }
}

public class UseModel2 {
    public static void main(String[] args) {
        new AbstractPrint() {

            @Override
            void open() {
                System.out.print("{{{");
            }

            @Override
            void print() {
                System.out.print("A");
            }

            @Override
            void close() {
                System.out.print("}}}");
                System.out.println();
            }
        }.run();
    }

}
