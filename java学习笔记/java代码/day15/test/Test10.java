package test;

/**
 * 
/*★
====第十题====================================
 假如我们在开发一个系统时需要对员工进行建模，员工包含 3 个属性：
姓名、工号以及工资。经理也是员工，除了含有员工的属性外，另为还有一个
奖金属性。请使用继承的思想设计出员工类和经理类。要求类中提供必要的方
法进行属性访问。 

思路：
员工分普通员工和经理。
1，首先将两个共性的东西向上抽取。（姓名，age，id,工资。有一个工作方法。）
    因为普通和经理工作内容不同。需要这两个子类自己去实现。那么该方法是抽象的。（好处，普通和经理只要是员工就必须工作，强制性。）
2，在定义经理类，除了拿到父类中共性的东西，他还有特性的东西。（奖金）
*/
public class Test10 {


}

class Manager extends Dept {

    private int bonus;

    public Manager(String name, String no, int wage, int bonus) {
        super(name, no, wage);
        this.bonus = bonus;
    }

    public void work() {
        super.work();
        System.out.println("子");
    }
}

class Dept {
    private String name;

    public Dept(String name, String no, int wage) {
        super();
        this.name = name;
        this.no = no;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Dept [name=" + name + ", no=" + no + ", wage=" + wage + "]";
    }

    private String no;

    private int wage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public void work() {
        System.out.println("work");
    }
}