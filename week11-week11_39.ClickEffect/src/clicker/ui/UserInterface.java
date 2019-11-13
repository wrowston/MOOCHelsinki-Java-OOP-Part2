package clicker.ui;

import clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        JLabel countLabel = new JLabel("0");
        JButton clickButton = new JButton("Click!");

        ClickListener clickListener = new ClickListener(this.calculator, countLabel);
        clickButton.addActionListener(clickListener);

        container.add(countLabel, BorderLayout.NORTH);
        container.add(clickButton, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
