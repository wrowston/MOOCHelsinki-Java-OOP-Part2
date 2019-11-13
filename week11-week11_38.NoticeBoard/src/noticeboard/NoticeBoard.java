package noticeboard;

import javax.swing.*;
import java.awt.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Notice Board");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JTextField textField = new JTextField();
        JButton copyButton = new JButton("Copy!");
        JLabel copiedText = new JLabel();

        ActionEventListener copier = new ActionEventListener(textField, copiedText);
        copyButton.addActionListener(copier);

        container.add(textField);
        container.add(copyButton);
        container.add(copiedText);
    }
}
