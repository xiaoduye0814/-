package awtstudy;

import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddButton {

    // 乱码问题解决：
    /*
     * ① 右键点击项目——Run Configuration对话框
     * ② 选择Commons 选项卡，讲3的UTF-8改为GB18030 
     * ② 点击Apply(提交) 按钮保存运行配置并点击 Run(运行) 按钮重新执行 Java 应用。
     */

    /**
     * @param args
     * @throws InterruptedException 
     */
    private static int num = 1;

    private static Frame frame;
    public static void main(String[] args) throws InterruptedException {
        frame = new Frame();
        frame.setSize(1000, 800);
        frame.setLocation(100, 100);
        frame.setLayout(new FlowLayout());
        frame.setTitle("my window");
        Button btn = new Button("增加 Button");
        frame.add(btn);
        frame.setVisible(true);
        handleEvent(frame, btn);
    }

    private static void handleEvent(Frame frame, Button btn) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addButton();
            }
        });
    }

    protected static void addButton() {
        Button btn = new Button("button" + (num++));
        frame.add(btn);
        frame.setVisible(true);
        handleAddButton(btn);
    }

    private static void handleAddButton(Button btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove((Component) e.getSource());
                frame.setVisible(true);
            }
        });
    }

}

