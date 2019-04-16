package awtstudy;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Frame f = new Frame("my window");
        f.setSize(200, 400);
        f.setLocation(100, 200);
        Button btn1 = new Button("please click me！！！！！！！！！！！！！");
        Button btn2 = new Button("please click me！！！！！！！！！！！！！");
        btn2.setVisible(false);

        f.add(btn1, "North");
        f.add(btn2, "South");

        f.setVisible(true);
        handleButton(f, btn1, btn2);
    }

    private static void handleButton(final Frame f, final Button btn1,
            final Button btn2) {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn1.setVisible(false);
                btn2.setVisible(true);
                f.setVisible(true);
            }
        });
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn2.setVisible(false);
                btn1.setVisible(true);
                f.setVisible(true);
            }
        });
    }

}
