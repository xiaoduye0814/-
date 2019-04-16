import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则分割文字和字符
 * @author Administrator
 *
 */
public class AscDemo {
    public static void main(String[] args) throws IOException {

        FileReader file = new FileReader("D:\\a.txt");
        int a = 0;
        String str = "";
        while ((a = file.read()) != -1) {
            str += (char) a;
        }

        String s = "\\d+.\\d+|\\w+";
        Pattern pattern = Pattern.compile(s);
        Matcher ma = pattern.matcher(str);

        while (ma.find()) {
            System.out.println(ma.group());
        }

    }
}