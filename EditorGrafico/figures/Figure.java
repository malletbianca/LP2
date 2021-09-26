package figures;

import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int rot;
    public int stroke;
    public int rStroke, gStroke, bStroke;

    public Figure (int x, int y, int rot, int stroke, int rStroke, int gStroke, int bStroke) {
    	this.x = x;
        this.y = y;
        this.rot = rot;
        this.stroke = stroke;
        this.rStroke = rStroke;
        this.gStroke = gStroke;
        this.bStroke = bStroke;
    }

    public abstract void paint (Graphics g);
    
}
