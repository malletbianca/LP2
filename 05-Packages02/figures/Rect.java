package figures;

import java.awt.*;

public class Rect {
    int x, y;
    int w, h;
    int r1, g1, b1;
    int r2, g2, b2;
    int stroke;

    public Rect (int x, int y, int w, int h, int r1, int g1, int b1, int stroke, int r2, int g2, int b2) {
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

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.r1, this.g1, this.b1));
        g2d.fillRect(this.x,this.y, this.w,this.h);

        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
