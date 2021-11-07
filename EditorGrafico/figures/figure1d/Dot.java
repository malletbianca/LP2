package figures.figure1d;

import figures.*;
import java.awt.*;
import java.awt.Graphics;

public class Dot extends Figure {

    public Dot (int x, int y, int stroke, int rStroke, int gStroke, int bStroke) {
        super(x,y, stroke, rStroke, gStroke, bStroke);
        this.stroke = 8;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
        g2d.fillOval(this.x - (this.stroke/2),this.y - (this.stroke/2), this.stroke,this.stroke);
    }

    public boolean clicked (int mouseX, int mouseY) {
        return (mouseX >= this.x - (this.stroke/2)) && (mouseX <= this.x + (this.stroke/2)) && (mouseY >= this.y - (this.stroke/2)) && (mouseY <= this.y + (this.stroke/2));
    }

    public void randomColor (int r, int g, int b) {
        this.rStroke = r;
        this.gStroke = g;
        this.bStroke = b;
    }

    public void scale (int scaleWidth, int scaleHeight) {
        this.stroke += scaleWidth;

        // Evita que a figura seja reduzida indefinidamente
        if (this.stroke < 3) {
            this.stroke -= scaleWidth;
        }
    }

    public void addSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.RED);
        g2d.drawOval(this.x - (this.stroke/2),this.y - (this.stroke/2), this.stroke,this.stroke);

    }
}
