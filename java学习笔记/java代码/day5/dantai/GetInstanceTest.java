package dantai;

/**
 * 单例设计模式
 * @author Administrator
 *
 */
public class GetInstanceTest {

    public static void main(String[] args) {
        Person p1 = Person.getInstance();
        Person p2 = Person.getInstance();
        System.out.println(p1 == p2);
    }

}

class Person {
    private Person() {
    }

    private static Person p = new Person();

    public static Person getInstance() {
        return p;
    }
}
