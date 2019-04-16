package day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("ab");
        al.add("aadc");
        al.add("aaa");
        al.add("asfsgfdfgfg");
        al.add("sfdger");
        al.add("zz");
        al.add("hgfdvsd");

        Collections.sort(al);
        System.out.println(Collections.binarySearch(al, "aaa"));
        for (String str : al) {
            System.out.println(str);
        }
        System.out.println("================================");
        Collections.sort(al, new MyComparator());
        System.out.println(Collections.binarySearch(al, "aaa",
            new MyComparator()));
        for (String str : al) {
            System.out.println(str);
        }
        System.out.println("================================");
        System.out.println(binarySearch(al, "hgfdvsa", new MyComparator()));
    }

    static <T> int binarySearch(List<T> l, T key, Comparator<T> com) {
        int min = 0;
        int max = l.size() - 1;
        int mid = 0;
        while (max >= min) {
            mid = (min + max) / 2;
            if (com.compare(key, l.get(mid)) > 0) {
                min = mid + 1;
            } else if (com.compare(key, l.get(mid)) < 0) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        if (com.compare(key, l.get(mid)) > 0) {
            return -mid - 2;
        } else {
            return -mid - 1;
        }
    }
}

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int num = s1.length() - s2.length();
        if (num != 0) {
            return num;
        }
        return s1.compareTo(s2);
    }

}
