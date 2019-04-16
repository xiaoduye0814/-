package day12;

import java.io.FileNotFoundException;
import java.util.Calendar;

public class CalendarTest {

    public static void main(String[] args) throws FileNotFoundException {
        // 修改输出地址
        //        System.setOut(new PrintStream("day/a.txt"));
        Calendar c = Calendar.getInstance();
        int nu1m = c.get(Calendar.DAY_OF_MONTH);
        // 计算某年的二月有多少天
        int num = 2008;
        getNum(num);
        Calendar start = Calendar.getInstance();
        // 100天完工，开始今天，周末休息，10一五一放一天假
        Calendar finish = getFinishDate(start);

        int cha = finish.get(finish.DAY_OF_YEAR) - c.get(c.DAY_OF_YEAR);
        System.out.println(cha + "天");

    }

    /**
     * 100天完工，开始今天，周末休息，10一五一放一天假
     * @param c
     * @return
     */
    private static Calendar getFinishDate(Calendar c) {
        for (int i = 0; i < 100; i++) {
            if (c.get(c.DAY_OF_WEEK) == 1 || c.get(c.DAY_OF_WEEK) == 7) {
                i--;
            }
            if ((c.get(c.MONTH) == 4 || c.get(c.MONTH) == 9)
                    && (c.get(c.DAY_OF_MONTH) == 1)) {
                i--;
            }
            c.add(c.DAY_OF_YEAR, 1);
        }
        System.out.println(c.get(c.YEAR) + "年" + (c.get(c.MONTH) + 1) + "月"
                + c.get(c.DAY_OF_MONTH) + "日");
        return c;
    }

    /**
     * 计算某年的二月有多少天
     * @param num
     */
    private static void getNum(int num) {
        Calendar c = Calendar.getInstance();
        c.set(num, 2, 1);
        c.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
}
