package movingfigure;

import java.awt.*;

public class Circle extends Figure {
    private int diameter;

    public Circle(int x, int y, int diameter) {
        super(x,y);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval(this.getX(), this.getY(), diameter, diameter);
    }
}