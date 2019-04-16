package test;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
/*★★★★★
====第二十二题==================================
取出一个字符串中字母出现的次数。如："abcdekka27qoq"  a(2)b(1)k(2)...
思路：
1，先将字符串转换成字符数组。
2，定义一个计数器，记录每一个字母出现的次数。
3，将字母作为key。该字母出现的次数作为value。将两者存入map集合中。
（为什么要用map集合呢？因为字母有很多，数据多了就要想到用容器多存入。方便操作。而每一个字母都有对应的次数。正好有映射关系。而map集合正好符合这个特点。map集合可以同时存入两个对象。key会保证唯一性。只要不断改变该key对应的值就可以了。）
4，在遍历字符数组进行存储的时候要判断，该字母是否已经存在于map集合。如果已存在。就取出它所对应的次数，并++.在次存入到集合中。
5，遍历该集合就可以得到结果。

（注意，如果只取字母的话，要进行字符'a'-'z'的判断。其他字符比如数字或者符号就没有必要存入map集合了。）
*/
public class Test22 {
    public static void main(String[] args) {
        String str = "hhhaaabb";
        char [] ch = str.toCharArray();
        TreeSet<Character> ts = new TreeSet<Character>();
        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>(
                new Comparator<Character>() {
                    @Override
                    public int compare(Character o1, Character o2) {
                        return o1 - o2;
                    }
                });
        for (int i = 0; i < ch.length; i++) {
            if (ts.contains(ch[i])) {
                tm.put(ch[i], tm.get(ch[i]) + 1);
            } else {
                ts.add(ch[i]);
                tm.put(ch[i], 1);
            }
        }
        Set<Entry<Character, Integer>> ens = tm.entrySet();
        for (Entry<Character, Integer> e : ens) {
            System.out.println(e.getKey() + "  " + e.getValue());
        }
    }
}
