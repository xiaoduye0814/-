package day12;

import java.text.DateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = DateFormat.getInstance();
        String str = df.format(date);
        System.out.println(str);
    }
}
