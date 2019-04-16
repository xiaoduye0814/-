package day12;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * abaac 输出 a(3) b(1) c(1)
 * @author Administrator
 *
 */
public class Test {
    public static void main(String[] args) {
        String str = "aaaabbbccccc";
        run(str);
    }

    private static void run(String str) {
        char[] c = str.toCharArray();
        String s = "";
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        for (int i = 0; i < c.length; i++) {
            if (!s.contains(String.valueOf(c[i]))) {
                s += c[i];
                tm.put(String.valueOf(c[i]), 1);
            } else {
                int value = tm.get(String.valueOf(c[i])) + 1;
                tm.put(String.valueOf(c[i]), value);
            }
        }
        Set<Entry<String, Integer>> entrys = tm.entrySet();
        TreeSet<Entry<String, Integer>> ts = new TreeSet<Entry<String, Integer>>(
                new Comparator<Entry<String, Integer>>() {
                    @Override
                    public int compare(Entry<String, Integer> e1,
                            Entry<String, Integer> e2) {
                        int num = e1.getValue() - e2.getValue();
                        if (num != 0) {
                            return -num;
                        }
                        return e1.getKey().compareTo(e2.getKey());
                    }
        });
        for (Entry<String, Integer> entry : entrys) {
            ts.add(entry);
        }
        for (Entry<String, Integer> entry : ts) {
            System.out.println(entry.getKey() + "=====" + entry.getValue());
        }
    }
}
