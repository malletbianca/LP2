package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, y;
    int rot;
    int rFill, gFill, bFill;
    int stroke;
    int rStroke, gStroke, bStroke;

    public abstract void paint (Graphics g);
}
