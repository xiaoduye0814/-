package reflectstudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflect1 {

    /**
     * 反射：获得对象运行时候的类
     * @param args
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws InstantiationException 
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object obj = new Person("xiaohong", 19);
        // 第一种getClass方法
        Class clazz1 = obj.getClass();
        // 第二种，通过表示类名的字符串
        String className = "reflectstudy.Person";
        Class clazz2 = Class.forName(className);
        // 第三种 ，明确的去获得那个类型
        Class clazz3 = Person.class;
        System.out.println("对象的名称为：" + clazz2.getName());
        System.out.println(clazz1 == clazz2);

        /**
         * 获得基本数据类型的Class对象
         */
        Class intclazz = int.class;
        Class voidclazz = void.class;
        System.out.println("基本数据类型对象的名称为：" + voidclazz.getName());

        /**
         * 获得类中的所有属性
         */
        System.out.println();
        System.out.println("------------------------");
        System.out.println("获得类中的所有属性");
        Class clazz = Person.class;
        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            String type = field.getType().getName();
            //            Object value = field.get(obj);访问对象属性为private修饰的成员会执行非法访问异常
            System.out.println("属性类型：  " + type + "属性名称： " + name);
        }
        System.out.println("************");
        System.out.println("将obj的name属性设置为小红");
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);// 设置java编辑器取消对该属性的访问权限语法检查
        Object nameValue = nameField.get(obj);
        System.out.println("name的属性值为：  " + nameValue);
        //        nameField.setAccessible(false);
        nameField.set(obj, "小红");
        System.out.println(obj);

        /**
         * 获得类中定义的方法
         */
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("获得类中定义的方法");
        Method methods[] = clazz.getDeclaredMethods();
        for (Method m : methods) {
            String name = m.getName();
            Class returnType = m.getReturnType();
            System.out.print("方法名： " + name + "返回值类型为：" + returnType
                    + "参数列表为： ");
            Class[] parameterTypes = m.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + "\t");
            }
            System.out.println();
        }

        // 调用obj的setName方法将名字改为李四
        System.out.println("************");
        System.out.println("调用obj的setName方法将名字改为李四");
        Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
        setNameMethod.invoke(obj, "李四");
        System.out.println(obj);

        /**
         * 获得类中定义的构造方法
         */
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("获得类中定义的构造方法");
        Constructor constructors[] = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("构造方法名称： " + name + "构造方法参数列表：");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType.getName() + ",    ");
            }
            System.out.println();
        }
        System.out.println("************");
        System.out.println("根据有参的构造方法构造对象");
        //        Constructor constructor = clazz.getConstructor(new Class[] {
        //                String.class, int.class });
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object o1 = constructor.newInstance("赵六", 19);
        Person p1 = (Person) o1;
        System.out.println(p1);

        /**
         * 获得类所在的包
         */
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("获得类所在的包");
        Package pag = clazz.getPackage();
        System.out.println("包名称: " + pag);

        /**
         * 获得类的修饰符
         */
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("获得类的修饰符");
        int modifier = clazz.getModifiers();
        //        System.out.println(modifier);
        //        if (modifier == Modifier.PUBLIC) {
        //            System.out.println("这个类是public的");
        //        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("类实例");
        Class clazzA = A.class;
        int num = clazzA.getModifiers();
        if (Modifier.isPublic(num)) {
            System.out.println("这个类是public的类");
        }
        if (Modifier.isAbstract(num)) {
            System.out.println("这个类是abstract修饰的");
        }
        if(Modifier.isFinal(num)){
            System.out.println("这个类是final修饰的");
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("接口实例");
        Class bClazz = B.class;
        if (Modifier.isInterface(bClazz.getModifiers())) {
            System.out.println("B是接口");
        }
        if (Modifier.isPublic(bClazz.getModifiers())) {
            System.out.println("接口是public修饰的");
        }
        Method meth = bClazz.getMethod("b");
        int methodModifier = meth.getModifiers();
        if (Modifier.isPublic(methodModifier)) {
            System.out.println("接口中的方法默认是由public修饰的");
        }
        if (Modifier.isAbstract(methodModifier)) {
            System.out.println("接口中的方法默认是由abstract修饰的");
        }
    }
}

class Person {
    private String name;

    private int age;

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

final class A {

}

interface B {
    void b();
}
