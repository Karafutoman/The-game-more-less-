package guessingGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame {
    private JTextField txtGuess;
    private JLabel lblOutput;
    private int randomNumber;

    public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";
        try {
            int guess = Integer.parseInt(guessText);
            if (guess < randomNumber)
                message = guess + " это число меньше. Попробуйте ещё.";
            else if (guess > randomNumber)
                message = guess + " это число больше. Попробуйте ещё.";
            else {
                message = guess +
                        " Правильно! Вы победили!!!";
                newGame();
            }
        } catch (Exception e) {
            message = "Число должно быть от 0 до 100. Начинайте угадывать!";
        } finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }

    public void newGame() {
        randomNumber = (int) (Math.random() * 100 + 1);
    }

    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Karafutoman: Guessing Game");
        getContentPane().setLayout(null);

        JLabel lblDrPaynesHilo = new JLabel("Karafutoman: Guessing Game");
        lblDrPaynesHilo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblDrPaynesHilo.setHorizontalAlignment(SwingConstants.CENTER);
        lblDrPaynesHilo.setBounds(10, 37, 414, 24);
        getContentPane().add(lblDrPaynesHilo);

        JLabel lblGuessANumber = new JLabel("Число должно быть от 0 до 100");
        lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGuessANumber.setBounds(10, 98, 272, 14);
        getContentPane().add(lblGuessANumber);

        txtGuess = new JTextField();
        txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.setBounds(292, 95, 43, 20);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        JButton btnGuess = new JButton("Guess!");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        btnGuess.setBounds(172, 149, 89, 23);
        getContentPane().add(btnGuess);

        lblOutput = new JLabel("Введите число и нажмите на Guess!");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(10, 209, 414, 14);
        getContentPane().add(lblOutput);
    }

    public static void main(String[] args) {
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setSize(new Dimension(450, 300));
        theGame.setVisible(true);

    }
}
