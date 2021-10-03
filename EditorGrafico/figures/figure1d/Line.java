package figures.figure1d;

import figures.*;
import java.awt.*;
import java.awt.Graphics;

public class Line extends Figure {
    int width;

    public Line (int x, int y, int width, int stroke, int rStroke, int gStroke, int bStroke) {
        super(x,y, stroke, rStroke, gStroke, bStroke);
        this.width = width;
        this.stroke = 3;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
        g2d.setStroke(new BasicStroke(this.stroke));
        g2d.drawLine(this.x,this.y, this.width + this.x,this.y);
    }

    public boolean clicked (int mouseX, int mouseY) {
        return (mouseX >= this.x) && (mouseX <= this.x + this.width) && (mouseY >= this.y) && (mouseY <= this.y + this.stroke);
    }

    public void randomColor (int r, int g, int b) {
        this.rStroke = r;
        this.gStroke = g;
        this.bStroke = b;
    }

    public void scale (int scaleWidth, int scaleHeight) {
        this.width += scaleWidth;

        // Evita que a figura seja reduzida indefinidamente
        if (this.width < 3) {
            this.width -= scaleWidth;
        }
    }

    public void addSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.RED);
        g2d.drawRect(this.x - 3,this.y - 3, this.width + 3, 6);

    }
}
