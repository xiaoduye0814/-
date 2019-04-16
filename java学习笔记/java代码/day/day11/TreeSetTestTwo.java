package day11;


public class TreeSetTestTwo {

    public static void main(String[] args) {
        /*TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int num = str1.length() - str2.length();
                if (num != 0)
                    return num;
                return str1.compareTo(str2);
            }
        });
        ts.add("aaasfsdf");
        ts.add("ab");
        ts.add("afgdhgrt");
        ts.add("gbdtgergt");
        ts.add("asfefter");

        for (String str : ts) {
            System.out.println(str);
        }*/
        /*
         * HashSet<People> hs = new HashSet<People>(); hs.add(new People("付佳",
         * "北票", 20)); hs.add(new People("付佳", "北票", 20)); hs.add(new
         * People("小明", "男票", 10)); hs.add(new People("晓静", "东票", 26)); for
         * (People p : hs) { System.out.println(p); }
         */
    }
}

class People implements Comparable {

    private String name;

    private String school;

    private int age;

    @Override
    public String toString() {
        return "People [name=" + name + ", school=" + school + ", age=" + age
                + "]";
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public int getAge() {
        return age;
    }

    public People(String name, String school, int age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        People p = null;
        if (obj instanceof People)
            p = (People) obj;
        if (this.name.equals(p.name) && this.school.equals(p.school)
                && this.age == p.age)
            return true;
        return false;
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() * 31 + school.hashCode() * 31 + age;
    }

    @Override
    public int compareTo(Object obj) {
        People p = null;
        if(obj instanceof People)
            p = (People) obj;
        int age = this.age - p.age;
        if (age != 0)
            return age;
        if (this.name.compareTo(p.name) > 0)
            return 1;
        return 0;
    }
}