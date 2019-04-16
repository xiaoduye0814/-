package interfaceStudy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;

interface Database{
    int[] getDatebase();
}

interface Generator{
    int[] generator();
}

interface DataHandler{
    int[] handlerData();
}

// 甲君写的代码，数据库层
class MySql implements Database {
    public int[] getDatebase() {
        int[] arr = { 11, 33, 55, 212, 23, 21, 87, 2111 };
        return arr;
    }
}

// 甲1君写的代码，数据库层
class Oracle implements Database {
    public int[] getDatebase() {
        int[] arr = { 99, 999, 111, 222, 9999, 344 };
        return arr;
    }
}

// 乙君写的代码，数据产生器
class OneGenerator implements Generator {
    private Database database;
    public OneGenerator(Database database) {
        this.database = database;
    }
    public int[] generator() {
        int data[] = database.getDatebase();
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
        return data;
    }
}

// 乙2君写的代码，数据产生器
class TwoGenerator implements Generator {
    private Database database;

    public TwoGenerator(Database database) {
        this.database = database;
    }
    public int[] generator() {
        int data[] = database.getDatebase();
        for (int i = 0; i < data.length - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[pos]) {
                    pos = j;
                }
            }
            int temp = data[pos];
            data[pos] = data[i];
            data[i] = temp;
        }
        return data;
    }
}

//丙君写的代码，数据处理器
class OneDataHandler implements DataHandler {

    private Generator generator;

    public OneDataHandler(Generator generator) {
        this.generator = generator;
    }

    public int[] handlerData() {
        int data[] = generator.generator();
        for (int i = 0; i < data.length; i++) {
            data[i]++;
        }
        return data;
    }
}

//丙2君写的代码，数据处理器
class TwoDataHandler implements DataHandler {

    private Generator generator;

    public TwoDataHandler(Generator generator) {
        this.generator = generator;
    }

    public int[] handlerData() {
        int data[] = generator.generator();
        for (int i = 0; i < data.length; i++) {
            data[i]--;
        }
        return data;
    }
}

public class Demo4 {

    public static void main(String[] args) throws Exception {
        //        Database database = new DataBaseImpl();
        //        Generator generator = new OneGenerator(database);
        //        DataHandler datahandler = new OneDataHandler(generator);
        //        int data[] = datahandler.handlerData();
        //        for (int i = 0; i < data.length; i++) {
        //            System.out.print(data[i] + "  ");
        //        }
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1.通过反射获得数据库对象
        System.out.println("请输出你的数据库：");
        String databasrClassName = br.readLine();
        // 1-1根据类名反射出类
        Class databaseClazz = Class.forName(databasrClassName);
        // 1-2根据类创造出类的实例对象
        Database database = (Database) databaseClazz.newInstance();
        // 2.通过反射获得数据产生器
        System.out.println("请输出你的数据产生器：");
        String generatorClassName = br.readLine();
        // 2-1根据类名反射出类
        Class generatorClazz = Class.forName(generatorClassName);
        // 2-2获得该类指定的构造器
        Constructor generatorConstructor = generatorClazz
                .getConstructor(Database.class);
        // 2-3根据构造器创造出类的实例对象
        Generator generator = (Generator) generatorConstructor
                .newInstance(database);
        // 3.通过反射获得数据处理器
        System.out.println("请输出你的数据处理层：");
        String dataHandlerClassName = br.readLine();
        // 3-1根据类名反射出类
        Class dataHandlerClazz = Class.forName(dataHandlerClassName);
        // 3-2获得该类指定的构造器
        Constructor dataHandlerConstructor = dataHandlerClazz
                .getConstructor(Generator.class);
        // 3-3根据构造器创造出类的实例对象
        DataHandler dataHandler = (DataHandler) dataHandlerConstructor
                .newInstance(generator);
        int data[] = dataHandler.handlerData();
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "  ");
        }
        */
        BufferedReader br = new BufferedReader(new FileReader(
                "E:/myEclipse/text/src/interfaceStudy/a.txt"));
        // 1.通过反射获得数据库对象
        String databasrClassName = br.readLine();
        // 1-1根据类名反射出类
        Class databaseClazz = Class.forName(databasrClassName);
        // 1-2根据类创造出类的实例对象
        Database database = (Database) databaseClazz.newInstance();
        // 2.通过反射获得数据产生器
        String generatorClassName = br.readLine();
        // 2-1根据类名反射出类
        Class generatorClazz = Class.forName(generatorClassName);
        // 2-2获得该类指定的构造器
        Constructor generatorConstructor = generatorClazz
                .getConstructor(Database.class);
        // 2-3根据构造器创造出类的实例对象
        Generator generator = (Generator) generatorConstructor
                .newInstance(database);
        // 3.通过反射获得数据处理器
        String dataHandlerClassName = br.readLine();
        // 3-1根据类名反射出类
        Class dataHandlerClazz = Class.forName(dataHandlerClassName);
        // 3-2获得该类指定的构造器
        Constructor dataHandlerConstructor = dataHandlerClazz
                .getConstructor(Generator.class);
        // 3-3根据构造器创造出类的实例对象
        DataHandler dataHandler = (DataHandler) dataHandlerConstructor
                .newInstance(generator);
        int data[] = dataHandler.handlerData();
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "  ");
        }
    }
}

/*
 * 请输出你的数据库： interfaceStudy.DataBaseImpl 请输出你的数据产生器： interfaceStudy.OneGenerator
 * 请输出你的数据处理层： interfaceStudy.OneDataHandler
 */
