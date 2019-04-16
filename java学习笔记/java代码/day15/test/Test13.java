package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * /*★★
====第十三题==================================
找出一个整数数组{2,4,1,4,3,2,4,3,2}出现次数最多的数。2(3)  4(3)
//找字符串中出现过多少个字符，统计每个字符出现的次数，并且把字符按照次数升序排列。
 * 
 */

public class Test13 {
    public static void main(String[] args) {
        int[] target = { 2, 4, 1, 4, 3, 2, 4, 3, 2 };
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Arrays.sort(target);
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (int i = 0; i < target.length; i++) {
            if (!ts.contains(target[i])) {
                tm.put(target[i], 1);
                ts.add(target[i]);
            } else {
                tm.put(target[i], tm.get(target[i]) + 1);
            }
        }
        Set<Entry<Integer, Integer>> s = tm.entrySet();
        TreeSet<Entry<Integer, Integer>> tsN = new TreeSet<Map.Entry<Integer, Integer>>(
                new Comparator<Entry<Integer, Integer>>() {

                    @Override
                    public int compare(Entry<Integer, Integer> o1,
                            Entry<Integer, Integer> o2) {
                        int num = o1.getValue() - o2.getValue();
                        if (num != 0) {
                            return -num;
                        }
                        return o1.getKey() - o2.getKey();
                    }
                });
        for(Entry<Integer, Integer> en:s){
            tsN.add(en);
        }
        int pos = 0;
        for (Entry<Integer, Integer> entry : tsN) {
            if (entry.getValue() >= pos) {
                pos = entry.getValue();
            }
            if (entry.getValue() < pos) {
                break;
            }
            System.out.println(entry.getKey() + "=====" + entry.getValue());
        }
    }
}
