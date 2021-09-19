package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    int width, height;

    public Ellipse (int x, int y, int width, int height, int rFill, int gFill, int bFill, int stroke, int rStroke, int gStroke, int bStroke) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rFill = rFill;
        this.gFill = gFill;
        this.bFill = bFill;
        this.stroke = stroke;
        this.rStroke = rStroke;
        this.gStroke = gStroke;
        this.bStroke = bStroke;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rFill, this.gFill, this.bFill));
        g2d.fillOval(this.x,this.y, this.width,this.height);

        g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.drawOval(this.x,this.y, this.width,this.height);
    }
}
