package reflecttest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

/**
 * 根据反射获取任意图形的面积
 * @author Administrator
 *
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        /**
         * 获取圆形面积
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入你需要获得面积的图形");
        String className = "reflecttest." + br.readLine(); //记住是需要带包名称的，替换为你自己的包名称
        Class clazz;
        try {
            clazz = Class.forName(className);
        } catch (Exception e) {
            System.out.println("不好意思，没有这个图形");
            return;
        }

        // 获得构造参数
        Area a = (Area) clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("请输入属性" + f.getName() + "的值");
            f.setAccessible(true);
            f.setDouble(a, Double.parseDouble(br.readLine()));
        }
        double area = a.getArea();
        System.out.println("面积：" + area);

    }

}

interface Area {
    double getArea();
}

class Circular implements Area {
    private double r;
    public double getArea() {
        return Math.PI * r * r;
    }
}

class Rectangle implements Area {
    private double chang;

    private double kuan;

    public double getArea() {
        return chang * kuan;
    }
}