import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
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
    boolean buttonClicked = false;

    ListFrame () {
        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception x) {
            System.out.println("Erro ao abrir arquivo");
        }

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    try {
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    } catch (Exception x) {
                        System.out.println("Erro ao escrever arquivo");
                    }
                    System.exit(0);
                }
            }
        );

        buttons.add(new Control(0, new Rect(40,60, 30,30, 1, 255,255,255, 200,200,200)));
        buttons.add(new Control(1, new Ellipse(40,110, 30,30, 1, 255,255,255, 200,200,200)));
        buttons.add(new Control(2, new Triangle(40,160, 30,30, 1, 255,255,255, 200,200,200)));
        buttons.add(new Control(3, new Line(40,225, 30, 1, 255,255,255)));
        buttons.add(new Control(4, new Dot(55,275, 1, 255,255,255)));

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed(MouseEvent evt) {
                    mousePosition = evt.getPoint();
                    selected = null;

                    // Executa só se tiver algum botão selecionado
                    if (buttonSelected != null) {
                        // Confere se o clique seguinte é dentro de um botão
                        buttonClicked = false;
                        for (Control button: buttons) {
                            if (button.clicked(mousePosition.x, mousePosition.y)) {
                                buttonClicked = true;
                            }
                        }
                        
                        // Só executa se o clique seguinte for fora de um botão
                        if (buttonClicked == false) {  
                            Point p = MouseInfo.getPointerInfo().getLocation();
                            int x = p.x - getLocation().x;
                            int y = p.y - getLocation().y;
                            int width = 60;
                            int height = 60;
                            int stroke = 0;
                            int rStroke = rand.nextInt(255);
                            int gStroke = rand.nextInt(255);
                            int bStroke = rand.nextInt(255);
                            int rFill = rand.nextInt(255);
                            int gFill = rand.nextInt(255);
                            int bFill = rand.nextInt(255);

                            switch (buttonSelected.getIdx()) {
                                case 0:
                                    selected = new Rect(x,y, width,height, stroke, rStroke,gStroke,bStroke, rFill,gFill,bFill);
                                    figs.add(selected);
                                    break;
                                case 1:
                                    selected = new Ellipse(x,y, width,height, stroke, rStroke,gStroke,bStroke, rFill,gFill,bFill);
                                    figs.add(selected);
                                    break;
                                case 2:
                                    selected = new Triangle(x,y, width,height, stroke, rStroke,gStroke,bStroke, rFill,gFill,bFill);
                                    figs.add(selected);
                                    break;
                                case 3:
                                    selected = new Line(x,y, width, stroke, rStroke,gStroke,bStroke);
                                    figs.add(selected);
                                    break;
                                case 4:
                                    selected = new Dot(x,y, stroke, rStroke,gStroke,bStroke);
                                    figs.add(selected);
                                    break;
                                default:
                            }
                        }
                    }

                    buttonSelected = null;

                    // Executa para conferir se clicou em algum botão
                    for (Control button: buttons) {
                        if (button.clicked(mousePosition.x, mousePosition.y)) {
                            buttonSelected = button;
                        }
                    }
                    repaint();

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
                    int rFill = rand.nextInt(255);
                    int gFill = rand.nextInt(255);
                    int bFill = rand.nextInt(255);

                    // Altera botão selecionado de acordo com tecla selecionada
                    switch (evt.getKeyChar()) {
                        case 'r': case 'R':
                            for (Control button: buttons) {
                                if (button.getIdx() == 0) {
                                    buttonSelected = button;
                                }
                            }
                            break;
                        case 'e': case 'E':
                            for (Control button: buttons) {
                                if (button.getIdx() == 1) {
                                    buttonSelected = button;
                                }
                            }
                            break;
                        case 't': case 'T':
                            for (Control button: buttons) {
                                if (button.getIdx() == 2) {
                                    buttonSelected = button;
                                }
                            }
                            break;
                        case 'l': case 'L':
                            for (Control button: buttons) {
                                if (button.getIdx() == 3) {
                                    buttonSelected = button;
                                }
                            }
                            break;
                        case 'd': case 'D':
                            for (Control button: buttons) {
                                if (button.getIdx() == 4) {
                                    buttonSelected = button;
                                }
                            }
                            break;
                        case KeyEvent.VK_ESCAPE:
                            buttonSelected = null;
                            break;
                        default:
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
