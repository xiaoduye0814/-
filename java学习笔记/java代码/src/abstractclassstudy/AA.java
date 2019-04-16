package abstractclassstudy;

// 定义抽象类作为接口，实现个模块之间的解耦

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 定义一个抽象的数据产生器
abstract class Generator {
    abstract String getData();
}

//定义一个抽象的数据处理器
abstract class DataHandler {
    abstract String handleData(Generator generator);
}

//甲君负责写数据产生器
class OneGenerator extends Generator {
    public String getData() {
        return "holle";
    }
}

class TwoGenerator extends Generator {
    public String getData() {
        return "中国人";
    }
}

//乙君负责写数据处理器
class OneDataHandler extends DataHandler {
    public String handleData(Generator generator) {
        String data = generator.getData();
        return "--" + data + "--";
    }
}

class TwoDataHandler extends DataHandler {
    public String handleData(Generator generator) {
        String data = generator.getData();
        return "~~~" + data + "~~~";
    }
}

//数据显示
class Demo {
    public static void main(String args[]) throws Exception {
        /*
         * DataHandler dataHandler = new OneDataHandler(); Generator generator =
         * new OneGenerator();
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //反射：获得对象的类型
        // Person.class-->new Person()-->张三
        // Class.class-->new Class()对象-->Person.class

        //1.获得数据产生器对象
        //1-1.通过读键盘获得用户使用的数据产生器名字
        System.out.println("请输入您使用的数据产生器");
        String generatorClassName = br.readLine();
        //1-2.根据类名反射出类
        Class generatorClazz = Class.forName(generatorClassName);
        //1-3.根据类创建实例对象(数据产生器)
        Generator generator = (Generator) generatorClazz.newInstance();

        //2.通过反射获得数据处理器对象
        System.out.println("请输入您使用的数据处理器");
        String dataHandlerClassName = br.readLine();
        Class dataHandlerClazz = Class.forName(dataHandlerClassName);
        DataHandler dataHandler = (DataHandler) dataHandlerClazz.newInstance();

        //Object-->Generator-->OneGenerator

        String data = dataHandler.handleData(generator);
        System.out.println(data);

    }
}
public class AA {
    public static void main(String args[]) throws Exception {
        /*
         * DataHandler dataHandler = new OneDataHandler(); Generator generator =
         * new OneGenerator();
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //反射：获得对象的类型
        // Person.class-->new Person()-->张三
        // Class.class-->new Class()对象-->Person.class

        //1.获得数据产生器对象
        //1-1.通过读键盘获得用户使用的数据产生器名字
        System.out.println("请输入您使用的数据产生器");
        String generatorClassName = br.readLine();
        //1-2.根据类名反射出类
        Class generatorClazz = Class.forName(generatorClassName);
        //1-3.根据类创建实例对象(数据产生器)
        Generator generator = (Generator) generatorClazz.newInstance();

        //2.通过反射获得数据处理器对象
        System.out.println("请输入您使用的数据处理器");
        String dataHandlerClassName = br.readLine();
        Class dataHandlerClazz = Class.forName(dataHandlerClassName);
        DataHandler dataHandler = (DataHandler) dataHandlerClazz.newInstance();

        //Object-->Generator-->OneGenerator

        String data = dataHandler.handleData(generator);
        System.out.println(data);
    }
}
