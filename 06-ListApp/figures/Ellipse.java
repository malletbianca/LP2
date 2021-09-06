package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse {
    int x, y;
    int w, h;
    int r1, b1, g1;
    int stroke;
    int r2, b2, g2;

    public Ellipse (int x, int y, int w, int h, int r1, int g1, int b1, int stroke, int r2, int g2, int b2) {
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
        g2d.fillOval(this.x,this.y, this.w,this.h);

        g2d.setColor(new Color(this.r2, this.g2, this.b2));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
