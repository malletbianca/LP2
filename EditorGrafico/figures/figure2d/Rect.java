package figures.figure2d;

import figures.*;
import java.awt.*;
import java.awt.Graphics;

public class Rect extends Figure2D {

    public Rect (int x, int y, int width, int height, int stroke, int rStroke, int gStroke, int bStroke, int rFill, int gFill, int bFill) {
        super(x,y, width,height, stroke, rStroke, gStroke, bStroke, rFill, gFill, bFill);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.rFill, this.gFill, this.bFill));
        g2d.fillRect(this.x,this.y, this.width,this.height);

        if (stroke > 0) {
            g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
            g2d.setStroke(new BasicStroke(this.stroke));
            g2d.drawRect(this.x,this.y, this.width,this.height);
        }
    }

    public void addSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.RED);
        g2d.drawRect(this.x,this.y, this.width,this.height);

    }
}
