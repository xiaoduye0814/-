package day11;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        //        TreeSet<Person> ts = new TreeSet<Person>(new MyComparator());
        TreeSet<Person> ts = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int num = p1.getAge() - p2.getAge();
                if (num != 0) {
                    return num;
                }
                return p1.getName().compareTo(p2.getName());
            }
        });
        ts.add(new Person("小红", 10));
        ts.add(new Person("小红2", 18));
        ts.add(new Person("小红", 10));
        ts.add(new Person("小红", 12));
        ts.add(new Person("小红1", 12));
        for (Person p : ts) {
            System.out.println(p);
        }
    }
}
/**
 * 比较器
 */
/*
 * class MyComparator implements Comparator<Person> {
 * 
 * @Override public int compare(Person p1, Person p2) { if (p1.getAge() >
 * p2.getAge()) { return 1; } if (p1.getAge() < p2.getAge()) { return -1; } if
 * (p1.getName().compareTo(p2.getName()) > 0) { return 1; } if
 * (p1.getName().compareTo(p2.getName()) < 0) { return -1; } return 0; }
 * 
 * }
 */