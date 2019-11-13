package greeter.ui;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Swing on");
        this.frame.setPreferredSize(new Dimension(400, 200));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel label = new JLabel("Hi!");
        container.add(label);
    }

    public JFrame getFrame() {
        return frame;
    }
}
