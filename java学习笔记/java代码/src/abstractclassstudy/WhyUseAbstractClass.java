package abstractclassstudy;

// 甲写的代码（接口或者抽象类）
abstract class A {
    abstract void a();

    abstract void b();

    abstract void c();

    abstract void d();
}

abstract class AbstractA extends A {
    public void a() {

    }

    public void b() {

    }

    public void c() {

    }

    public void d() {

    }
}

class C {
    public void run(A a) {
        a.a();
    }
}

// 乙写的代码（就是我们写的代码，调用的接口）
public class WhyUseAbstractClass {
    public static void main(String[] args) {
        C c = new C();
        // 匿名内部类，需要哪个方法就在里面写哪个方法，无需覆盖所有的方法
        c.run(new AbstractA() {
            public void a() {
                System.out.println("a() in C");
            }
        });
    }
}
