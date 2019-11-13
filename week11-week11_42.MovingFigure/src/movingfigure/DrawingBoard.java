package movingfigure;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {
    private Figure obj;

    public DrawingBoard(Figure obj) {
        this.obj = obj;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.obj.draw(g);
    }
}
