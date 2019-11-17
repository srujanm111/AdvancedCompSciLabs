package Lab10_Snowflake;

import javax.swing.*;
import java.awt.*;

public class RecursiveGraphicsPanel extends JPanel {

    public RecursiveGraphicsPanel() {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        super.paintComponent(g);
        g.setColor(Color.BLUE);

        new RealSierpinski().paint(g, height, width);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Draw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RecursiveGraphicsPanel());
        frame.pack();
        frame.setVisible(true);
    }

}
