package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import readerandwrrter.CloseUtil;

public class StudentSourceTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new FileWriter("day13/source.txt"));
            String[] str = { "语文", "数学", "英语" };
            TreeSet<Person> ts = new TreeSet<Person>(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    int num = o1.getSum() - o2.getSum();
                    if (num != 0) {
                        return -num;
                    }
                    return o1.getName().compareTo(o2.getName());
                }
            });
            int num = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 2; i++) {
                System.out.println("请输入第" + (i + 1) + "位学生姓名:");
                String name = br.readLine();
                for (int j = 0; j < str.length; j++) {
                    System.out.println("请输入此位学生" + str[j] + "成绩:");
                    try {
                        String grade = br.readLine();
                        num += Integer.parseInt(grade);
                        sb = sb.append(grade + ",");
                    } catch (NumberFormatException e) {
                        e.getMessage();
                    }
                }
                String sou[] = sb.toString().split(",");
                ts.add(new Person(name, num, sou[0], sou[1], sou[2]));
                num = 0;
                sb = new StringBuilder();
            }
            bw.write("  姓名                  数学成绩              语文成绩                    英语成绩                 总成绩");
            bw.newLine();
            for (Person p : ts) {
                bw.write(p.getName() + "        " + p.getsSource() + "       "
                        + p.getcSource() + "       " + p.getbSource()
                        + "        " + p.getSum());
                bw.newLine();
            }
            Iterator<Person> iter = ts.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next().getSum());
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                CloseUtil.closeUtil(br, bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Person {
    private String name;

    private int sum;

    private String sSource;

    private String bSource;

    private String cSource;

    public Person(String name, int sum, String sSource, String bSource,
            String cSource) {
        super();
        this.name = name;
        this.sum = sum;
        this.sSource = sSource;
        this.bSource = bSource;
        this.cSource = cSource;
    }

    public String getsSource() {
        return sSource;
    }

    public String getbSource() {
        return bSource;
    }

    public String getcSource() {
        return cSource;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

}