import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setBackground(new Color(71, 196, 109));
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int w = getWidth();
        int h = getHeight();

        g2d.setColor(new Color(71, 196, 109));
        g2d.fillRect(0, 0, getWidth(), getHeight());
      
        g2d.setPaint(Color.white);
        g2d.setStroke(new BasicStroke(7, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        //Posiciona as gráficos a partir de uma grid 16/16
        g2d.drawOval(3*w/16, 3*h/16, 5*w/8, 5*h/8);
        g2d.drawLine(5*w/16,h/2, 7*w/16,5*h/8);
        g2d.drawLine(7*w/16,5*h/8, 11*w/16,3*h/8);
        
    }
}
