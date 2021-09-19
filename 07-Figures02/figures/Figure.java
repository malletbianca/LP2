package figures;

import java.awt.Graphics;

public abstract class Figure {
    int x, y;
    int w, h;
    int r1, g1, b1;
    int stroke;
    int r2, g2, b2;

    public abstract void paint (Graphics g);
}
