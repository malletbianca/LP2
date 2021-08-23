import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, 71,196,109, 3, 0,0,0);
        this.r2 = new Rect(100,100, 30,100, 63,169,245, 5, 0,0,0);
        this.r3 = new Rect(150,200, 50,50, 0,0,0, 3, 63,169,245);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int r1, g1, b1;
    int r2, g2, b2;
    int stroke;

    Rect (int x, int y, int w, int h, int r1, int g1, int b1, int stroke, int r2, int g2, int b2) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r1 = r1;
        this.g1 = g1;
        this.b1 = b1;
        this.stroke = stroke;
        this.r2 = r2;
        this.g2 = g2;
        this.b2 = b2;
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.fillRect(this.x,this.y, this.w,this.h);

        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.drawRect(this.x,this.y, this.w,this.h);
        
    }
}
