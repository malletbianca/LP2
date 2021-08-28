package figures;

import java.awt.*;

public class Triangle {
    int x[] = new int[3];
    int y[] = new int[3];
    
    public Triangle (int x1, int x2, int x3, int y1, int y2, int y3) {
        this.x[0] = x1;
        this.x[1] = x2;
        this.x[2] = x3;
        this.y[0] = y1;
        this.y[1] = y2;
        this.y[2] = y3;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(this.x, this.y, 3);
    }
}
