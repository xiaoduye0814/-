package awtstudy;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameTest {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        frame.setSize(1000, 800);
        frame.setLocation(100, 100);
        frame.setTitle("my window");

        Button btn = new Button("close");
        frame.add(btn);
        frame.setLayout(new FlowLayout());

        frame.setVisible(true);


        // 事件监听1
        /*
         * Thread.sleep(1000); frame.setVisible(false); frame.dispose();
         * System.exit(0);
         */
        
        // 事件监听2
        // frame.addWindowListener(new MyWindowListener());

        // 事件监听3 使用监听器的适配器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 1、直接获取时间源
                //                e.getWindow().dispose();
                // 2、通过组建关闭
                /*
                 * Component com = e.getComponent(); Window win = (Window) com;
                 * win.dispose();
                 */
                // 3、通过getsource获取
                ((Window) e.getSource()).dispose();
            }
        });
        
        // 按钮监听事件1
        /*
         * btn.addMouseListener(new MouseAdapter() {
         * 
         * @Override public void mouseClicked(MouseEvent e) { // 1、第一种
         * 
         * Component com = e.getComponent(); Window win = (Window)
         * com.getParent(); // 获取事件源，就是获取按钮 win.dispose();
         * 
         * 
         * // 2、第二种 Component com = (Component) e.getSource(); Window win =
         * (Window) com.getParent(); win.dispose(); // 简写 //
         * ((Window)((Component)e.getSource()).getParent()).dispose(); //
         * ((Window)e.getSource()).dispose(); 不能直接转成window对象 } });
         */

        // 按钮监听事件2
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Window) ((Button) e.getSource()).getParent()).dispose();
            }
        });

    }

}

class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}