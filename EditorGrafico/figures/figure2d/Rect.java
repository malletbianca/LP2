package figures.figure2d;

import figures.*;
import java.awt.*;
import java.awt.Graphics;

public class Rect extends Figure2D {

    public Rect (int x, int y, int rot, int stroke, int rStroke, int gStroke, int bStroke, int width, int height, int rFill, int gFill, int bFill) {
        super(x,y, rot, stroke, rStroke, gStroke, bStroke, width, height, rFill, gFill, bFill);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rFill, this.gFill, this.bFill));
        g2d.fillRect(this.x,this.y, this.width,this.height);

        if (stroke > 0) {
            g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
            g2d.setStroke(new BasicStroke(this.stroke));
            g2d.drawRect(this.x,this.y, this.width,this.height);
        }
    }
}
