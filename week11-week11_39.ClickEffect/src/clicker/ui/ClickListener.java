package clicker.ui;

import clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {

    private Calculator calculator;
    private JLabel count;

    public ClickListener(Calculator calculator, JLabel count) {
        this.calculator = calculator;
        this.count = count;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculator.increase();
        this.count.setText(this.calculator.giveValue() + "");
    }
}
