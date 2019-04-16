package text;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * GUI实现记事本
 * @author Administrator
 *
 */
public class TextBen {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new MyTest();
    }

}

class MyTest {

    private Frame frame;

    private MenuBar menuBar;

    private Menu menu;

    private MenuItem open, save, close;

    private TextArea textArea;

    public MyTest() {
        frame = new Frame("我的记事本");
        frame.setSize(600, 400);
        frame.setLocation(100, 100);

        menuBar = new MenuBar();
        menu = new Menu("文件  (F)");
        open = new MenuItem("打开  (O)  Ctrl+O");
        save = new MenuItem("保存  (S)  Ctrl+S");
        close = new MenuItem("关闭  (C)");
        textArea = new TextArea(60, 70);

        menu.add(open);
        menu.add(save);
        menu.add(close);
        menuBar.add(menu);
        frame.setMenuBar(menuBar);
        frame.add(textArea);
        frame.setVisible(true);
        handleEvent();

    }

    public void handleEvent() {
        // 关闭窗体功能
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        // 打开文件夹功能
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        // 附加内容，快捷键
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
                    openFile();
                }
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
                    saveFileAll();
                }
            }
        });

        // 另存为功能
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFileAll();
            }
        });

        // 退出功能
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }

    /**
     * 另存为
     */
    protected void saveFileAll() {
        FileDialog savFileDialog = new FileDialog(frame, " 保  存 ",
                FileDialog.SAVE);
        savFileDialog.setVisible(true);
        String dirName = savFileDialog.getDirectory();
        String fileName = savFileDialog.getFile();
        File saveFile = new File(dirName, fileName);
        try {
            saveFile(saveFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 打开文件
     */
    protected void openFile() {
        // 创建文件对话框对象
        FileDialog openFileDialog = new FileDialog(frame, " 打 开 ",
                FileDialog.LOAD);
        // 设置对话框可见，会发生阻塞，直到用户选择文件
        openFileDialog.setVisible(true);
        // 获取用户选中的文件所在的目录和文件名
        String dirName = openFileDialog.getDirectory();
        String fileName = openFileDialog.getFile();
        // 创建file对象
        File file = new File(dirName, fileName);
        // 判断file是否存在，不存在，弹出错误面板
        if (!file.exists()) {
            createOpenFileErrorDialog(file);
            return;
        }
        // 通过io流读取文件，存入text
        try {
            openFile(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 保存文件
     * @param saveFile
     * @throws IOException
     */
    protected void saveFile(File saveFile) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(saveFile));
            String data = textArea.getText();
            bw.write(data);
        } finally {
            if (bw != null) {
                bw.close();
            }
        }

    }

    /**
     * 创建错误窗体
     * @param file
     */
    protected void createOpenFileErrorDialog(File file) {
        Dialog errorDialog = new Dialog(frame, "错误提示", true);
        errorDialog.add(new Label("系统找不到指定文件" + file.getName()), "Center");
        errorDialog.setSize(200, 100);
        errorDialog.setLocation(200, 200);
        Button btn = new Button("确定");
        errorDialog.add(btn, "South");
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ((Window) e.getComponent().getParent()).dispose();
            }

        });
        errorDialog.setVisible(true);
    }

    /**
     * 打开文件
     * @param file
     * @throws IOException
     */
    protected void openFile(File file) throws IOException {
        // 创建流用bufferedreader
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            // 清空文本域
            textArea.setText("");
            // 读取读一行村一行
            String line = "";
            while ((line = br.readLine()) != null) {
                textArea.append(line);
                textArea.append("\r\n");
            }
        } catch (Exception e) {
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}