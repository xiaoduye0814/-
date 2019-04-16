import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * 文档加密解密
 * @author Administrator
 *
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(
                "E://学习文件夹//java学习笔记//Secret3.txt");
        FileOutputStream fos = new FileOutputStream(
                "E://学习文件夹//java学习笔记//Secret1.txt");
        int ch;
        System.out.println("请输入密钥：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = br.readLine();
        while ((ch = fis.read()) != -1) {
            ch = ch ^ Integer.valueOf(key);
            fos.write(ch);
        }

    }
}
