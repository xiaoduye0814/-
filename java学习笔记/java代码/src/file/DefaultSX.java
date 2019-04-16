package file;

import java.io.File;
import java.util.Date;

public class DefaultSX {

    public static void main(String[] args) {

        File file = new File("D:\\hello.txt");
        System.out.println("******文件属性测试******");
        System.out.println("是否存在:" + file.exists());
        System.out.println("文件名：" + file.getName());
        System.out.println("上级目录：" + file.getParent());
        System.out.println("是否可读：" + file.canRead());
        System.out.println("是否可写：" + file.canWrite());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("相对路径：" + file.getPath());
        System.out.println("是否为绝对路径：" + file.isAbsolute());
        System.out.println("是否为目录：" + file.isDirectory());
        System.out.println("是否为文件：" + file.isFile());
        System.out.println("是否为隐藏文件：" + file.isHidden());
        System.out.println("最后修改时间：" + new Date(file.lastModified()));
        System.out.println("文件长度：" + file.length());
    }
}
