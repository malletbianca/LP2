package figures.figure2d;

import figures.*;
import java.awt.Graphics;

public abstract class Figure2D extends Figure {
	public int width, height;
    public int rFill, gFill, bFill;

    public Figure2D (int x, int y, int rot, int stroke, int rStroke, int gStroke, int bStroke, int width, int height, int rFill, int gFill, int bFill) {
    	super(x,y, rot, stroke, rStroke, gStroke, bStroke);
    	this.width = width;
    	this.height = height;
    	this.rFill = rFill;
    	this.gFill = gFill;
    	this.bFill = bFill;
    }
}
