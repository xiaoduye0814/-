package day11;

public class CanChangeParam {

    public static void main(String[] args) {
        run(1, 2, 34, 5, 66, 90);
    }

    static void run(int... in) {
        System.out.println(in.length);
    }
}
