package equals;

import java.util.Collection;
import java.util.HashSet;

public class HelloWorld {
    public static void main(String[] args) {
        Name n1 = new Name("01");
        Name n2 = new Name("01");

        Collection c = new HashSet();
        c.add(n1);
        c.add(n2);
        System.out.println(n1.equals(n2));
    }

}

class Name {
    private String id;

    public Name(String id) {
        this.id = id;
    }

    public String toString() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            Name name = (Name) obj;
            return (id.equals(name.id));
        }
        if (null == obj)
            return false;
        return super.equals(obj);
    }

}