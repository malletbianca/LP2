import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;
import figures.figure1d.*;
import figures.figure2d.*;

class EditorGraficoApp {
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
                    Point m = MouseInfo.getPointerInfo().getLocation();
                    int x = m.x - getLocation().x;
                    int y = m.y - getLocation().y;
                    int rot = 0;
                    int width = rand.nextInt(100 + 1 - 10) + 10; //int randomNumber = random.nextInt(max + 1 - min) + min;
                    int height = rand.nextInt(100 + 1 - 10) + 10;
                    int rFill = rand.nextInt(255);
                    int gFill = rand.nextInt(255);
                    int bFill = rand.nextInt(255);
                    int stroke = rand.nextInt(7);
                    int rStroke = rand.nextInt(255);
                    int gStroke = rand.nextInt(255);
                    int bStroke = rand.nextInt(255);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, rot, stroke, rStroke,gStroke,bStroke, width,height, rFill,gFill,bFill));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, rot, stroke, rStroke,gStroke,bStroke, width,height, rFill,gFill,bFill));
                    } else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangle(x,y, rot, stroke, rStroke,gStroke,bStroke, width,height, rFill,gFill,bFill));
                    } else if (evt.getKeyChar() == 'l') {
                        figs.add(new Line(x,y, rot, stroke, rStroke,gStroke,bStroke, width));
                    } else if (evt.getKeyChar() == 'd') {
                        figs.add(new Dot(x,y, rot, stroke, rStroke,gStroke,bStroke));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Editor Grafico");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
