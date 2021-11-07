import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;
import figures.figure1d.*;
import figures.figure2d.*;
import interfaces.*;
import buttons.*;

class EditorGraficoApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Control> buttons = new ArrayList<Control>();

    Random rand = new Random();
    Figure selected = null;
    Control buttonSelected = null;
    Point mousePosition = null;

    ListFrame () {
        buttons.add(new Control(0, new Rect(40,60, 30,30, 1, 255,255,255, 200,200,200)));
        buttons.add(new Control(1, new Ellipse(40,110, 30,30, 1, 255,255,255, 200,200,200)));
        buttons.add(new Control(2, new Triangle(40,160, 30,30, 1, 255,255,255, 200,200,200)));
        buttons.add(new Control(3, new Line(40,225, 30, 1, 255,255,255)));
        buttons.add(new Control(4, new Dot(55,275, 1, 255,255,255)));
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed(MouseEvent evt) {
                    mousePosition = evt.getPoint();
                    selected = null;
                    buttonSelected = null;
                    
                    // Figuras
                    for (Figure fig: figs) {
                        if (fig.clicked(mousePosition.x, mousePosition.y)) {
                            selected = fig;
                        }
                    }
                    if (selected != null) {
                        figs.remove(selected);
                        figs.add(selected); // Adiciona na posição mais próxima
                    }
                    repaint();
                    
                    // Botões
                    for (Control button: buttons) {
                        if (button.clicked(mousePosition.x, mousePosition.y)) {
                            buttonSelected = button;
                        }
                    }
                    repaint();
                }
            }
        );

        this.addMouseMotionListener (
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent evt) {
                    if (selected != null) {
                        int dx = evt.getX() - mousePosition.x;
                        int dy = evt.getY() - mousePosition.y;
                        selected.drag(dx, dy);
                        repaint();
                    }
                    mousePosition = evt.getPoint();
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    Point m = MouseInfo.getPointerInfo().getLocation();
                    int x = m.x - getLocation().x;
                    int y = m.y - getLocation().y;
                    int width = 60;
                    int height = 60;
                    int stroke = 0;
                    int rStroke = rand.nextInt(255);
                    int gStroke = rand.nextInt(255);
                    int bStroke = rand.nextInt(255);
                    int rFill = rand.nextInt(255);
                    int gFill = rand.nextInt(255);
                    int bFill = rand.nextInt(255);

                    // Eventos de criação de figura
                    if (evt.getKeyChar() == 'r' || evt.getKeyChar() == 'R') {
                        selected = new Rect(x,y, width,height, stroke, rStroke,gStroke,bStroke, rFill,gFill,bFill);
                        figs.add(selected);
                    } else if (evt.getKeyChar() == 'e' || evt.getKeyChar() == 'E') {
                        selected = new Ellipse(x,y, width,height, stroke, rStroke,gStroke,bStroke, rFill,gFill,bFill);
                        figs.add(selected);
                    } else if (evt.getKeyChar() == 't' || evt.getKeyChar() == 'T') {
                        selected = new Triangle(x,y, width,height, stroke, rStroke,gStroke,bStroke, rFill,gFill,bFill);
                        figs.add(selected);
                    } else if (evt.getKeyChar() == 'l' || evt.getKeyChar() == 'L') {
                        selected = new Line(x,y, width, stroke, rStroke,gStroke,bStroke);
                        figs.add(selected);
                    } else if (evt.getKeyChar() == 'd' || evt.getKeyChar() == 'D') {
                        selected = new Dot(x,y, stroke, rStroke,gStroke,bStroke);
                        figs.add(selected);
                    }

                    // Seleção da figura em foco pelo teclado
                    if (evt.getKeyChar() == '/') {
                        if (selected == null) {
                            if (figs.size() > 0) {
                                selected = figs.get(0);
                            }
                        } else {
                            selected = figs.get((figs.indexOf(selected) + 1) % figs.size());
                            figs.remove(selected);
                            figs.add(selected);
                        }
                    }

                    // Eventos para figura em foco
                    if (selected != null) {
                        if (evt.getKeyCode() == KeyEvent.VK_UP){
                            selected.drag(0,-5);
                        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                            selected.drag(0,5);
                        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT){
                            selected.drag(-5,0);
                        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
                            selected.drag(5,0);
                        } else if (evt.getKeyCode() == KeyEvent.VK_DELETE){
                            figs.remove(selected);

                        // Eventos de aumentar e diminuir o tamanho
                        } else if (evt.getKeyChar() == ']') {
                            selected.scale(3,3);
                        } else if (evt.getKeyChar() == '[') {
                            selected.scale(-3,-3);

                        // Evento para mudar cor da figura
                        } else if (evt.getKeyChar() == 'c' || evt.getKeyChar() == 'C') {
                            selected.randomColor(rFill, gFill, bFill);
                        }
                    }
                    repaint();
                }
            }
        );

        // Ajusta editor para tamanho da tela do usuário
        GraphicsDevice g2d = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        int screenWidth = g2d.getDisplayMode().getWidth();
        int screenHeight = g2d.getDisplayMode().getHeight();

        this.setTitle("Editor Grafico");
        this.setSize(screenWidth, screenHeight);
    }

    public void paint (Graphics g) {
        super.paint(g);
        
        for (Figure fig: this.figs) {
            fig.paint(g, fig == selected);
            if (fig == selected) {
                selected.addSelection(g);
            }
        }

        for (Control button: this.buttons) {
            button.paint(g, button == buttonSelected);
        }
    }
}
