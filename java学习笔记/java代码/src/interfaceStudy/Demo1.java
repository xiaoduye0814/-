package interfaceStudy;


interface IA {
    void a();

    void b();
}

//public class Demo1 {
//
//    public static void main(String[] args) {
//        class AA implements IA {
//            public void a() {
//                System.out.println("a() in AA");
//            }
//
//            public void b() {
//                System.out.println("b() in AA");
//            }
//        }
//        run(new AA());
//    }
//
//    public static void run(IA a) {
//        a.b();
//    }
//}
public class Demo1 {

    public static void main(String[] args) {
        run(new IA() {
            @Override
            public void a() {

            }
            @Override
            public void b() {
                System.out.println("b() in A");
            }

        });
    }

    public static void run(IA a) {
        a.b();
    }
}

