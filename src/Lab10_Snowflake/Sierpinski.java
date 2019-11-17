package Lab10_Snowflake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Sierpinski {

    public void paint(Graphics g, int length) {
        drawTriangle(g, 0, 0, length);
    }

    private void drawTriangle(Graphics g, int x, int y, int length) {
        if (length < 5) return;

        g.drawLine(x, y, x, y + length);
        g.drawLine(x, y, x + length, y);
        g.drawLine(x, y + length, x + length, y);

        drawTriangle(g, x, y, length/2);
        drawTriangle(g, x, y + length/2, length/2);
        drawTriangle(g, x + length/2, y, length/2);
    }

}
