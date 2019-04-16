package day12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Person, String> hm = new HashMap<Person, String>();
        hm.put(new Person("张三", 19), "zhangsan");
        hm.put(new Person("小美女", 29), "beauty");
        hm.put(new Person("小花", 20), "xiaohua");
        hm.put(new Person("张三", 19), "zhangSan");
        hm.put(new Person("小红", 20), "xiaohong");
        System.out.println(hm.size());
        System.out.println("==========================");

        Set<Person> keys = hm.keySet();
        Iterator<Person> iter = keys.iterator();
        while (iter.hasNext()) {
            Person p = iter.next();
            String value = hm.get(p);
            System.out.println(p + "::::" + value);
        }

        Set<Entry<Person, String>> entrys = hm.entrySet();
        for (Entry<Person, String> entry : entrys) {
            Person p = entry.getKey();
            String name = entry.getValue();
            System.out.println(p + "===========" + name);
        }
    }
}

class Person // implements Comparable 
{
    public String name;

    public int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (person.name.equals(name) && person.age == age) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + age;
    }

    /*
     * @Override public int compareTo(Object obj) { Person p = null; if (obj
     * instanceof Person) { p = (Person) obj; }
     * if(this.name.compareTo(p.name)>0){ return 1; }
     * if(this.name.compareTo(p.name)<0){ return -1; } if(this.age>p.age){
     * return 1; } if(this.age<p.age){ return -1; } return 0; }
     */

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
