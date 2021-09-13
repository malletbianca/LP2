import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(500);
                    int y = rand.nextInt(500);
                    int w = rand.nextInt(100);
                    int h = rand.nextInt(100);
                    int r1 = rand.nextInt(255);
                    int g1 = rand.nextInt(255);
                    int b1 = rand.nextInt(255);
                    int stroke = rand.nextInt(3);
                    int r2 = rand.nextInt(255);
                    int g2 = rand.nextInt(255);
                    int b2 = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect (x,y, w,h, r1,g1,b1, stroke, r2,g2,b2);
                        figs.add(r);
                    } else if (evt.getKeyChar() == 'e') {
                        //Ellipse e = new Ellipse(x,y, w,h, r1,g1,b1, stroke, r2,g2,b2);
                        //figs.add(e);
                        figs.add(new Ellipse(x,y, w,h, r1,g1,b1, stroke, r2,g2,b2));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Retangulos e Elipses");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
