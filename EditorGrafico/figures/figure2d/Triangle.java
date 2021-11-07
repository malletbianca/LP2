package figures.figure2d;

import figures.*;
import java.awt.*;
import java.awt.Polygon;
import java.awt.Graphics;

public class Triangle extends Figure2D {
    private Polygon triangle;
    
    public Triangle (int x, int y, int stroke, int rStroke, int gStroke, int bStroke, int width, int height, int rFill, int gFill, int bFill) {
        super(x,y, stroke, rStroke, gStroke, bStroke, width, height, rFill, gFill, bFill);

        triangle = new Polygon();
        triangle.xpoints = new int[] {this.x + (this.width/2), this.width + this.x, this.x};
        triangle.ypoints = new int[] {this.y, (this.height + this.y), (this.height + this.y)};
        triangle.npoints = 3;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rFill, this.gFill, this.bFill));
        g2d.fillPolygon(triangle);

        if (stroke > 0) {
            g2d.setColor(new Color(this.rStroke, this.gStroke, this.bStroke));
            g2d.setStroke(new BasicStroke(this.stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawPolygon(triangle);
        }
    }

    public void drag (int distanceX, int distanceY) {
        this.x += distanceX;
        this.y += distanceY;

        for (int i = 0; i < triangle.npoints; ++i) {
            triangle.xpoints[i] += distanceX;
            triangle.ypoints[i] += distanceY;
        }
    }

    public void scale (int scaleWidth, int scaleHeight) {
        this.width += scaleWidth;
        this.height += scaleHeight;

        triangle.xpoints = new int[] {this.x + (this.width/2), this.width + this.x, this.x};
        triangle.ypoints = new int[] {this.y, (this.height + this.y), (this.height + this.y)};
        
        // Evita que a figura seja reduzida indefinidamente
        if (this.width < 5) {
            this.width -= scaleWidth;
            this.height -= scaleHeight;
        }
    }

    public void addSelection(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.RED);
        g2d.drawPolygon(triangle);
    }
}
