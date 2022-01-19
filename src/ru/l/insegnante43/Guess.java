package ru.l.insegnante43;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Guess extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    int randomNumber = new Random().nextInt(5) + 1;
    int numGuesses = 0;

    JTextField textField = new JTextField(15);
    JButton button = new JButton("Сделать попытку");
    JLabel label = new JLabel(numGuesses + " попыток");

    public Guess() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout (new FlowLayout());
        add(textField);
        add(button);
        add(label);
        button.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textFieldText = textField.getText();

        if (Integer.parseInt(textFieldText)==randomNumber) {
            button.setEnabled(false);
            textField.setText("Угадал: " + textField.getText());
            textField.setEnabled(false);
        } else {
            textField.setText("");
            textField.requestFocus();
        }

        numGuesses++;
        String guessWord = (numGuesses == 1) ? " попытка" : " попыток";
        label.setText(numGuesses + guessWord);
    }
}
