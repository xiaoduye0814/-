package finalizestudy;

class Cat {
    static int count;

    public Cat() {
        count++;
    }

    public void finalize() {
        count--;
    }
}

public class FinalizeStudy {

    public static void main(String[] args) {
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        new Cat();
        new Cat();
        new Cat();
        new Cat();
        Cat c3 = new Cat();
        Cat c4 = new Cat();
        new Cat();
        new Cat();
        System.gc();
        /*
         * try { Thread.sleep(10000); } catch (InterruptedException e) {
         * e.printStackTrace(); }
         */
        for (int i = 0; i < 200000; i++)
            ;
        System.out.println(Cat.count);
    }
}
