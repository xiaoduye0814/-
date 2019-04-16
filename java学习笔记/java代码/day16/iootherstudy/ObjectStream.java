package iootherstudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectStream {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Person> as = new ArrayList<Person>();
        as.add(new Person("张三", 19));
        as.add(new Person("张三1", 19111));
        as.add(new Person("张三2", 1911));
        as.add(new Person("张三3", 191));
        //        Person p = new Person("张三", 19);
        /*
         * 序列化过程 ObjectOutputStream oos = new ObjectOutputStream(new
         * FileOutputStream( "day16/object.txt")); oos.writeObject(p);
         * oos.close();
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "day16/object.txt"));
        Object obj = ois.readObject();
        //        Person pF = (Person) obj;
        //        System.out.println(pF);
        ArrayList<Person> al = (ArrayList<Person>) obj;
        for (Person p : al) {
            System.out.println(p);
        }
    }
}
