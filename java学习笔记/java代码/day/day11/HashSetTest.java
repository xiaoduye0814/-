package day11;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {
        HashSet<Person> hs = new HashSet<Person>();
        hs.add(new Person("小红", 10));
        hs.add(new Person("小红2", 18));
        hs.add(new Person("小红", 10));
        hs.add(new Person("小红", 10));
        hs.add(new Person("小红1", 12));
        System.out.println(hs.size());
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
