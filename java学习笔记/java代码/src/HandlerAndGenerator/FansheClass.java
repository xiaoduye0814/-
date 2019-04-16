package HandlerAndGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 模拟数据产生器
 * @author Administrator
 *
 */
abstract class Generator {
    abstract String getData();
}

/**
 * 模拟数据处理器
 * @author Administrator
 *
 */
abstract class DataHandler {
    abstract String handleData(Generator generator);
}

class OneGenerator extends Generator {
    public String getData() {
        return "hello";
    }
}

class OneDataHandler extends DataHandler {
    public String handleData(Generator generator) {
        return "--" + generator.getData() + "--";
    }

}
public class FansheClass {
    public static void main(String[] args) throws Exception {
        String name = OneGenerator.class.getPackage().getName();
        System.out.println(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入您所使用的数据产生器：(包含有完整的包名称)");
        String generatorClassName = br.readLine();
        Class generatorClazz = Class.forName(generatorClassName);
        Generator generator = (Generator) generatorClazz.newInstance();
        System.out.println("请输入您所使用的数据处理器：(包含有完整的包名称)");
        String dataHandlerClassName = br.readLine();
        Class dataHandlerClazz = Class.forName(dataHandlerClassName);
        DataHandler dataHandler = (DataHandler) dataHandlerClazz
                .newInstance();
        String data = dataHandler.handleData(generator);
        System.out.println(data);
    }
}
