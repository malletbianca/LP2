import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class Pack2App {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Triangle t1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(1000, 400);
        this.r1 = new Rect(680,100, 200,200, 255,0,0, 3, 185,25,22);
        this.e1 = new Ellipse(400,100, 200,200, 0,0,255, 3, 32,32,160);
        this.t1 = new Triangle(235,350,120, 100,300,300, 255,255,0, 3, 221,167,34);
    }

    public void paint (Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        this.r1.paint(g);
        this.e1.paint(g);
        this.t1.paint(g);
    }
}
