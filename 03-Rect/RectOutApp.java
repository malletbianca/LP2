import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectOutApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
        r1.drag(10,10);
        r1.print();
    }
}

class Rect {
    int x, y;
    int w, h;
    int dx, dy;

    Rect (int xx, int yy, int ww, int hh) {
        this.x = xx;
        this.y = yy;
        this.w = ww;
        this.h = hh;
    }
  
    int calculaArea () {
    	return w * h;
    }

    void drag (int dxx, int dyy) {
        this.dx = dxx;
        this.dy = dyy;
        x = x + dx;
        y = y + dy;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na nova posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
        System.out.format("Area do retangulo (%d).\n", this.calculaArea());
    }
}
