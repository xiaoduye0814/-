package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * /*★★★★★
====第五题====================================
有五个学生，每个学生有3门课的成绩，定义一种比较直观的文本文件格式，
输入学生姓名和成绩，从键盘输入以上数据（包括姓名，三门课成绩），
按总分数从高到低的顺序将学生信息存放在磁盘文件"stu.txt"中。
思路：
1，获取键盘录入；
    a，System.in,为了更好读取键盘录入信息。一行一行的读会更方便，那么将其包装。
    b,BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
2，将获取的键盘录入封装成学生对象（首先要对学生类进行描述。）
    a,读到一行数据，通过该数据的规则（“，”）对数据进行切割。变成字符串数组。并把数组中的学生信息，作为参数，
    封装成学生对象。
3，将封装好的学生对象存入集合中
（why？因为要对这些对象中的信息进行操作，用哪个集合呢？既然要排序。而且是存入单个对象。TreeSet，定义比较器。）
    a.建立TreeSet集合，定一个比较器对象传给集合的构造函数。同过集合的add方法，将学生对象存入。
4，对已有元素的TreeSet集合，进行迭代。将其中的学生信息通过流写入到一个文件中。
    a.通过Iterator迭代器，迭代该集合。取出学生对象中要用的信息。作为字符串，用字符流对象（FileWriter）
    将其写入到一个文件中。

*/
public class Test5 {

    public static void main(String[] args) {
        TreeSet<People> ts = new TreeSet<People>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                int num = o1.getSum() - o2.getSum();
                if (num != 0) {
                    return -num;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        try {
            getTreeSet(ts);
            Iterator<People> iter = ts.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next().getSum());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getTreeSet(TreeSet<People> ts) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入，以，隔开");
        for (int i = 0; i < 5; i++) {
            String[] str = br.readLine().split(",");
            int sum = Integer.parseInt(str[1]) + Integer.parseInt(str[2])
                    + Integer.parseInt(str[3]);
            ts.add(new People(str[0], Integer.parseInt(str[1]), Integer
                    .parseInt(str[2]), Integer.parseInt(str[3]), sum));
        }
    }
}

class People {
    private String name;

    private int chinese;

    private int math;

    private int english;

    private int sum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(String name, int chinese, int math, int english, int sum) {
        super();
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", chinese=" + chinese + ", math="
                + math + ", english=" + english + ", sum=" + sum + "]";
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
