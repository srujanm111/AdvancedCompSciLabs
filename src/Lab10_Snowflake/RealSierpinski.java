package Lab10_Snowflake;

import java.awt.*;

public class RealSierpinski {

    public void paint(Graphics g, int height, int width) {
        drawTriangle(g, width/2, 0, width, height);
    }

    private void drawTriangle(Graphics g, int x, int y, int width, int height) {
        if (width < 5) return;

        g.drawLine(x, y, x-width/2, y + height);
        g.drawLine(x, y, x+width/2, y + height);
        g.drawLine(x-width/2, y + height, x+width/2, y + height);

        drawTriangle(g, x, y, width/2, height/2);
        drawTriangle(g, x - width/4, y + height/2, width/2, height/2);
        drawTriangle(g, x + width/4, y + height/2, width/2, height/2);
    }

}
