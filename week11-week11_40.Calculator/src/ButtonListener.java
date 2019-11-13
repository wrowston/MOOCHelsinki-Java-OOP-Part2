import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JButton plusButton;
    private JButton minusButton;
    private JButton clearButton;
    private JTextField inputField;
    private JTextField outputField;
    private ApplicationLogic calculator = new ApplicationLogic();

    public ButtonListener(JButton plusButton, JButton minusButton, JButton clearButton,
                          JTextField inputField, JTextField outputField) {
        this.plusButton = plusButton;
        this.minusButton = minusButton;
        this.clearButton = clearButton;
        this.inputField = inputField;
        this.outputField = outputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int input = 0;
        try {
            input = Integer.parseInt(this.inputField.getText());
        } catch (Exception ex) {
        }

        if (e.getSource() == this.plusButton) {
            this.calculator.plus(input);
        } else if (e.getSource() == this.minusButton) {
            this.calculator.minus(input);
        } else {
            this.calculator.reset();
        }

        this.outputField.setText("" + this.calculator.result());
        this.inputField.setText("");
        clearButtonPower();
    }

    public void clearButtonPower() {
        if (this.calculator.result() == 0) {
            this.clearButton.setEnabled(false);
        } else {
            this.clearButton.setEnabled(true);
        }
    }
}
