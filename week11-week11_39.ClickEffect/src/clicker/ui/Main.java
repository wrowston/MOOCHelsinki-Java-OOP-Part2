package clicker.ui;

import clicker.applicationlogic.PersonalCalculator;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new PersonalCalculator());
        SwingUtilities.invokeLater(ui);
    }
}
