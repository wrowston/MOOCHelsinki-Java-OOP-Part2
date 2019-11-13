package drawing.ui;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);

        graphics.fillRect(100, 50, 50, 50);
        graphics.fillRect(250, 50, 50, 50);

        graphics.fillRect(50, 200, 50, 50);
        graphics.fillRect(280, 200, 50, 50);

        graphics.fillRect(100, 250, 180, 50);
    }
}
