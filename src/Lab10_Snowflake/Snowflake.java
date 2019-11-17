package Lab10_Snowflake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel {
    public SnowFlakePanel() {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        /*
         * DRAWING CODE BELOW
         */
        for (int i = 0; i < (15); i++) {
            g.setColor(new Color((int)(Math.random() * 155 + 100), (int)(Math.random() * 155 + 100), (int)(Math.random() * 155 + 100)));
            drawSnowflake(g, (int)(Math.random() * (width-100) + 50), (int)(Math.random() * (height-100) + 50), (int)(Math.random() * 20 + 20));
        }
    }

    public void drawSnowflake(Graphics g, int x, int y, int length) {
        if (length < 5) return;
        g.drawLine(x-length/2, y, x+length/2, y);
        g.drawLine(((int) (x - (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y + (Math.sin(Math.toRadians(60)) * length / 2))), ((int) (x + (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y - (Math.sin(Math.toRadians(60)) * length / 2))));
        g.drawLine(((int) (x - (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y - (Math.sin(Math.toRadians(60)) * length / 2))), ((int) (x + (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y + (Math.sin(Math.toRadians(60)) * length / 2))));
        drawSnowflake(g, x-length/2, y, length/3);
        drawSnowflake(g, x+length/2, y, length/3);
        drawSnowflake(g, ((int) (x - (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y + (Math.sin(Math.toRadians(60)) * length / 2))), length/3);
        drawSnowflake(g, ((int) (x + (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y - (Math.sin(Math.toRadians(60)) * length / 2))), length/3);
        drawSnowflake(g, ((int) (x - (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y - (Math.sin(Math.toRadians(60)) * length / 2))), length/3);
        drawSnowflake(g, ((int) (x + (Math.cos(Math.toRadians(60)) * length / 2))), ((int) (y + (Math.sin(Math.toRadians(60)) * length / 2))), length/3);
    }
}

public class Snowflake {
    public static void main(String[] args) {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }
}