package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        /*
         * prop.setProperty("name", "晓静"); prop.setProperty("school", "北票");
         * prop.setProperty("age", "10"); prop.setProperty("age", "10");
         * 
         * @SuppressWarnings("unchecked") Enumeration<String> e =
         * (Enumeration<String>) prop.propertyNames(); while
         * (e.hasMoreElements()) { String key = e.nextElement(); String value =
         * prop.getProperty(key); System.out.println(key + "===========" +
         * value); }
         */

        /**
         * 从配置文件读取
         */
        /*
         * prop.load(new FileInputStream("day/a.properties")); //
         * System.out.println(prop.size()); String userName =
         * prop.getProperty("username"); String pwd = prop.getProperty("pwd");
         * System.out.println(userName + "==============" + pwd);
         */

        /**
         * 写入到配置文件
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String username = br.readLine();
        System.out.println("请输入密码：");
        String pwd = br.readLine();

        prop.setProperty("username", username);
        prop.setProperty("pwd", pwd);

        prop.list(new PrintStream("day/a.properties"));
    }
}
