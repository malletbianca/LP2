package figures.figure2d;

import figures.*;
import java.awt.Graphics;

public abstract class Figure2D extends Figure {
    int width, height;
    int rFill, gFill, bFill;

    public Figure2D (int x, int y, int width, int height, int stroke, int rStroke, int gStroke, int bStroke, int rFill, int gFill, int bFill) {
    	super(x,y, stroke, rStroke, gStroke, bStroke);
        this.width = width;
        this.height = height;
    	this.rFill = rFill;
    	this.gFill = gFill;
    	this.bFill = bFill;
    }

    public boolean clicked (int mouseX, int mouseY) {
        return (mouseX >= this.x) && (mouseX <= this.x + this.width) && (mouseY >= this.y) && (mouseY <= this.y + this.height);
    }

    public void scale (int scaleWidth, int scaleHeight) {
        this.width += scaleWidth;
        this.height += scaleHeight;

        // Evita que a figura seja reduzida indefinidamente
        if (this.width < 5) {
            this.width -= scaleWidth;
            this.height -= scaleHeight;
        }
    }

    public void randomColor (int r, int g, int b) {
        this.rFill = r;
        this.gFill = g;
        this.bFill = b;
    }
}
