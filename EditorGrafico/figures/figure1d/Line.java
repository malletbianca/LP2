package figures.figure1d;

import figures.*;
import java.awt.*;
import java.awt.Graphics;

public class Line extends Figure {
    int width;

    public Line (int x, int y, int rot, int stroke, int rStroke, int gStroke, int bStroke, int width) {
        super(x,y, rot, stroke, rStroke, gStroke, bStroke);
        this.width = width;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.drawLine(this.x,this.y, this.width + this.x,this.y);
    }
}
