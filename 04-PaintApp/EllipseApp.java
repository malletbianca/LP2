import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse");
        this.setSize(350, 350);
        this.e1 = new Ellipse(100,70, 150,150, 0,0,0, 255,0,0, 125, 3);
        this.e2 = new Ellipse(50,150, 150,150, 0,0,0, 0,255,0, 125, 3);
        this.e3 = new Ellipse(150,150, 150,150, 0,0,0, 0,0,255, 125, 3);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    int r1, g1, b1;
    int r2, g2, b2, alpha;
    int stroke;

    Ellipse (int x, int y, int w, int h, int r1, int g1, int b1, int r2, int g2, int b2, int alpha, int stroke) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
        this.alpha = alpha;
        this.stroke = stroke;
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.r2, this.g2, this.b2, this.alpha));
        g2d.fillOval(this.x,this.y, this.w,this.h);

        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
