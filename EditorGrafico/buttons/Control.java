package buttons;

import java.awt.Graphics;
import java.awt.*;

import figures.*;
import interfaces.IVisible;

public class Control implements IVisible {
    private int x, y;
    private int size = 50;
    private Figure figButton;
    private int idx;

    public Control (int idx, Figure figButton) {
        this.idx = idx;
        this.figButton = figButton;

        this.x = 30;
        this.y = size * idx + 50;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        
        if (focused) {
            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(new Color(20,20,20));
            g2d.fillRect(this.x, this.y, this.size, this.size);
            g2d.setPaint(Color.GRAY);
            g2d.drawRect(this.x, this.y, this.size, this.size);
        } else {
            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(new Color(90,90,90));
            g2d.fillRect(this.x, this.y, this.size, this.size);
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(this.x, this.y, this.size, this.size);
        }

        this.figButton.paint(g, true);
    }

    public boolean clicked (int mouseX, int mouseY) {
        return (mouseX >= this.x) && (mouseX <= this.x + this.size) && (mouseY >= this.y) && (mouseY <= this.size + (this.size * this.idx + 50));
    }

    public int getIdx() {
        return this.idx;
    }
}
