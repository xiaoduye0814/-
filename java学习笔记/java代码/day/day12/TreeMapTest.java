package day12;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Person, String> tm = new TreeMap<Person, String>(
                new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {
                        int num = p1.getAge() - p2.getAge();
                        if (num != 0) {
                            return num;
                        }
                        return p1.getName().compareTo(p2.getName());
                    }

                });
        tm.put(new Person("张三", 19), "zhangsan");
        tm.put(new Person("小美女", 29), "beauty");
        tm.put(new Person("小花", 20), "xiaohua");
        tm.put(new Person("张三", 19), "zhangSan");
        tm.put(new Person("小红", 20), "xiaohong");
        System.out.println(tm.size());
        System.out.println("==========================");

        Set<Person> keys = tm.keySet();
        Iterator<Person> iter = keys.iterator();
        while (iter.hasNext()) {
            Person p = iter.next();
            String value = tm.get(p);
            System.out.println(p + "::::" + value);
        }

        Set<Entry<Person, String>> entrys = tm.entrySet();
        for (Entry<Person, String> entry : entrys) {
            Person p = entry.getKey();
            String name = entry.getValue();
            System.out.println(p + "===========" + name);
        }
    }
}
