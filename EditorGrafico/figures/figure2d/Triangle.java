package figures.figure2d;

import figures.*;
import java.awt.*;

public class Triangle extends Figure2D {
    int numberOfSides = 3;
    int [] x = new int[numberOfSides];
    int [] y = new int[numberOfSides];
    
    public Triangle (int x, int y, int rot, int stroke, int rStroke, int gStroke, int bStroke, int width, int height, int rFill, int gFill, int bFill) {
        super(x,y, rot, stroke, rStroke, gStroke, bStroke, width, height, rFill, gFill, bFill);

        // Constroi triângulos equiláteros e isósceles
        this.x[0] = x + (width/2);
        this.x[1] = width + x;
        this.x[2] = x;

        this.y[0] = y;
        this.y[1] = height + y;
        this.y[2] = height + y;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rFill, this.gFill, this.bFill));
        g2d.fillPolygon(this.x, this.y, 3);

        if (stroke > 0) {
            g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
            g2d.setStroke(new BasicStroke(this.stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawPolygon(this.x, this.y, 3);
        }

    }
}
