package figures.figure1d;

import figures.*;
import java.awt.*;
import java.awt.Graphics;

public class Dot extends Figure {

    public Dot (int x, int y, int rot, int stroke, int rStroke, int gStroke, int bStroke) {
        super(x,y, rot, stroke, rStroke, gStroke, bStroke);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
        g2d.fillOval(this.x - (this.stroke/2),this.y - (this.stroke/2), this.stroke,this.stroke);
    }
}
