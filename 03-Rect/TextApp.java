//Texto em Java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextApp {
    public static void main (String[] args) {
        Text r1 = new Text(1,1, 0.0, 22,22,22, 14.5, 18.0, 0.1, 24,24,24, 0, "Arial", "Regular", 700);
        r1.print();
    }
}

class Text {
	int x, y; //posicao
	double rot; //rotacao
	int r1, g1, b1; //cor do texto
	double size; //tamanho da fonte
	double lineHeight; //tamanho da linha
	double spacing; //espaçamento da letra
	int r2, g2, b2; //cor do contorno
	int stroke; //espessura do contorno
	String fontFamily; //familia da fonte
	String fontStyle; //estilo da fonte
	int fontWeight; //peso da fonte
	Text (int x, int y, double rot, int r1, int g1, int b1, double size, double lineHeight, double spacing, int r2, int g2, int b2, int stroke, String fontFamily, String fontStyle, int fontWeight) {
		this.x = x;
		this.y = y;
		this.rot = rot;
		this.r1 = r1;
		this.g1 = g1;
		this.b1 = b1;
		this.size = size;
		this.lineHeight = lineHeight;
		this.spacing = spacing;
		this.r2 = r2;
		this.g2 = g2;
		this.b2 = b2;
		this.stroke = stroke;
		this.fontFamily = fontFamily;
		this.fontStyle = fontStyle;
		this.fontWeight = fontWeight;
	}

	void print() {
		System.out.format("Texto na posicao (%d, %d)\nRotacao (%.1f graus)\nCor de texto (%d, %d, %d)\nTamanho da fonte (%.1f)\nAltura da linha (%.1f)\nEspaco entre letras (%.1f)\nCor do contorno (%d, %d, %d)\nEspessura do contorno (%d)\nFamilia da fonte (%s)\nEstilo da fonte (%s)\nPeso da fonte (%d)\n", this.x, this.y, this.rot, this.r1, this.g1, this.b1, this.size, this.lineHeight, this.spacing, this.r2, this.g2, this.b2, this.stroke, this.fontFamily, this.fontStyle, this.fontWeight);
	}
}
