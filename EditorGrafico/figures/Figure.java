package figures;

import java.awt.Graphics;
import interfaces.*;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
    protected int x, y;
    protected int stroke;
    protected int rStroke, gStroke, bStroke;

    public Figure (int x, int y, int stroke, int rStroke, int gStroke, int bStroke) {
    	this.x = x;
        this.y = y; 
        this.stroke = stroke;
        this.rStroke = rStroke;
        this.gStroke = gStroke;
        this.bStroke = bStroke;
    }

    public void drag (int distanceX, int distanceY) {
        this.x += distanceX;
        this.y += distanceY;
    }
    
    public abstract void scale (int scaleWidth, int scaleHeight);

    public abstract void addSelection (Graphics g);

    public abstract void randomColor (int r, int g, int b);

}
