package day1;

import javax.swing.JOptionPane;

public class Person {

    public static void main(String[] args) {
        for (int i = 1; i > 0; i++) {
            if (i == 30) {
                break;
            }
            JOptionPane.showInputDialog(null, "6吗？第" + String.valueOf(i) + "遍",
                "关于你自己6不6的问题", JOptionPane.ERROR_MESSAGE, null, new String[] {
                        "6", "非常6", "6极了" }, "6爆表了");
        }
    }
}
