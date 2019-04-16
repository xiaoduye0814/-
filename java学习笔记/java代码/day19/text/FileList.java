package text;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * 计算机文件夹功能
 * @author Administrator
 *
 */
public class FileList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new MyList();
    }

}

class MyList {
    private Frame frame;

    private TextField textField;

    private Button toNext;

    private Button toBack;

    private List list;

    public MyList() {
        frame = new Frame();
        frame.setSize(600, 400);
        frame.setLocation(100, 100);

        textField = new TextField(55);
        toNext = new Button("转到下一级");
        toBack = new Button("返回上一级");
        list = new List(40);

        Panel panel = new Panel();
        panel.add(textField, "West");
        panel.add(toNext, "East");
        panel.add(toBack, "West");

        frame.add(panel, "North");
        frame.add(list, "Center");

        frame.setVisible(true);
        handleEvent();
    }

    private void handleEvent() {
        // 关闭按钮
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        // 转到按钮
        toNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listFiles();
            }
        });
        // 返回上一级按钮
        toBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // c:\Program Files\Java\jdk1.6.0_37
                String fileName = textField.getText();
                if (fileName.contains("\\")) {
                    int sub = fileName.lastIndexOf("\\");
                    fileName = fileName.substring(0, sub);
                    File file = new File(fileName);
                    if (file.isDirectory()) {
                        textField.setText(fileName);
                        listFiles();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "已经是根目录，无法再回退");
                    return;
                }
            }
        });
        // 输入文本之后点击回车动作
        textField.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                listFiles();
            }
        });
        // 双击列表动作
        list.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取点击的文件名称
                String fileName = list.getSelectedItem();
                // 获取父级目录路径
                String dirName = textField.getText();
                // 如果内容以：结尾，那么需要手动增加“\\”
                if (dirName.endsWith(":")) {
                    dirName += "\\";
                }
                // 根据文件名称和父级目录创建文件
                File file = new File(dirName, fileName);
                // 判断是标准文件还是文件夹
                if (file.isDirectory()) {
                    // 给表头赋值
                    textField.setText(file.getAbsolutePath());
                    listFiles();
                }
                // 如果是文件
                if (file.isFile()) {
                    try {
                        // 运行cmd命令执行程序
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec("cmd /c " + file.getAbsolutePath());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (!file.isDirectory() && !file.isFile()) {
                    createOpenFileErrorDialog(file);
                }
            }
        });
    }

    /**
     * 遍历文件
     */
    protected void listFiles() {
        // 获取输入框的内容
        String dirName = textField.getText();
        // 如果内容以：结尾，那么需要手动增加“\\”
        if (dirName.endsWith(":")) {
            dirName += "\\";
        }

        // 创建文件
        File file = new File(dirName);
        // 判断文件是否为目录并且是否存在
        if (!file.isDirectory()) {
            // 文件不存在出现提示消息
            createOpenFileErrorDialog(file);
            return;
        }
        // 遍历目录下所有的文件目录名称
        String[] dirNames = file.list();
        // 每次进行list赋值之前，首先清空list表单
        list.removeAll();
        // 进行列表赋值
        for (String dirNam : dirNames) {
            list.add(dirNam);
        }
    }

    /**
     * 遇到错误，显示错误窗体
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

}