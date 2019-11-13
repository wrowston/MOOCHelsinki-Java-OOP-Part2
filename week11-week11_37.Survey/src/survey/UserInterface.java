package survey;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));

        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        container.add(yes);
        container.add(no);

        container.add(new JLabel("Why?"));

        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton fun = new JRadioButton("Because it is fun!");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(noReason);
        buttonGroup.add(fun);
        container.add(noReason);
        container.add(fun);

        JButton done = new JButton("Done!");
        container.add(done);
    }


    public JFrame getFrame() {
        return frame;
    }
}
