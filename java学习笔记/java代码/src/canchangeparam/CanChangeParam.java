package canchangeparam;

public class CanChangeParam {

    public static void main(String[] args) {
        run(1, 122, 23123);
    }

    public static void run(int... num) {
        System.out.println(num);
    }
}
