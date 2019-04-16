import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;


public class JavaDocDemo extends Applet {
    public void init() {
        Button b;
        b = new Button("Hello");
        add(b);
        show();
    }

    public void paint(Graphics g) {
        int w = getSize().width, h = getSize().height;
        g.setColor(Color.yellow);
        g.fillRect(0, 0, w / 2, h);
        g.setColor(Color.green);
        g.fillRect(w / 2, 0, w, h);
        g.setColor(Color.red);
        g.drawString("Welcome to java", 50, 50);
    }

    public void show() {

    }

    public JavaDocDemo() {
        if (new java.util.Date().getDay() == 0) {
            throw new IllegalArgumentException("Never on a Sunday");

        }
    }
}
