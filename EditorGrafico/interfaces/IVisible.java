package interfaces;

import java.awt.*;

public interface IVisible {
	public boolean clicked (int mouseX, int mouseY);
	public void paint (Graphics g, boolean focused);
}
