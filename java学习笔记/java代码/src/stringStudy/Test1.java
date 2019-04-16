package stringStudy;

public class Test1 {

    public static void main(String[] args) {
        int num[] = { 1, 2, 7, 3, 4, 5 };
        for (int x = 0; x < num.length; x++) {
            for (int y = x + 1; y < num.length; y++) {
                if (num[x] > num[y]) {
                    int box = num[x];
                    num[x] = num[y];
                    num[y] = box;
                }
            }
            System.out.println(num[x]);
        }
    }
}
