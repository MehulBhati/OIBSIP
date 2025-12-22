package mehul.springframework.numberguessinggame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class ModernNumberGuessingGame extends JFrame implements ActionListener {

    private int randomNumber;
    private int attemptsLeft = 10;
    private int score = 0;

    private JTextField guessField;
    private JLabel messageLabel, attemptLabel, scoreLabel;
    private JButton guessButton, resetButton;

    private final Color BG_COLOR = new Color(34, 40, 49);       // dark background
    private final Color ACCENT_COLOR = new Color(0, 173, 181);  // teal
    private final Color TEXT_COLOR = new Color(238, 238, 238);  // light text

    public ModernNumberGuessingGame() {
        setTitle("🎯 Number Guessing Game");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout());
        getContentPane().setBackground(BG_COLOR);


        Font mainFont = new Font("Segoe UI", Font.PLAIN, 16);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        messageLabel = createLabel("I'm thinking of a number between 1 and 100...");
        attemptLabel = createLabel("Attempts left: " + attemptsLeft);
        scoreLabel = createLabel("Score: " + score);

        guessField = new JTextField();
        guessField.setFont(mainFont);
        guessField.setHorizontalAlignment(JTextField.CENTER);
        guessField.setBackground(new Color(57, 62, 70));
        guessField.setForeground(TEXT_COLOR);
        guessField.setBorder(BorderFactory.createLineBorder(ACCENT_COLOR, 2));
        guessField.setCaretColor(ACCENT_COLOR);

        guessButton = createButton("Guess");
        resetButton = createButton("Play Again");

        guessButton.addActionListener(this);
        resetButton.addActionListener(e -> resetGame());

        // Layout
        gbc.gridy = 0; add(messageLabel, gbc);
        gbc.gridy++; add(guessField, gbc);
        gbc.gridy++; add(guessButton, gbc);
        gbc.gridy++; add(attemptLabel, gbc);
        gbc.gridy++; add(scoreLabel, gbc);
        gbc.gridy++; add(resetButton, gbc);

        generateRandomNumber();
    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        return label;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(ACCENT_COLOR);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void generateRandomNumber() {
        randomNumber = new Random().nextInt(100) + 1;
    }

    private void resetGame() {
        attemptsLeft = 10;
        generateRandomNumber();
        messageLabel.setText("I'm thinking of a number between 1 and 100...");
        attemptLabel.setText("Attempts left: " + attemptsLeft);
        guessField.setText("");
        guessButton.setEnabled(true);
        guessButton.setBackground(ACCENT_COLOR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(guessField.getText().trim());
            attemptsLeft--;

            if (guess == randomNumber) {
                messageLabel.setText("🎉 Correct! The number was " + randomNumber);
                messageLabel.setForeground(new Color(0, 255, 127)); // green
                score += attemptsLeft * 10;
                scoreLabel.setText("Score: " + score);
                guessButton.setEnabled(false);
                guessButton.setBackground(new Color(100, 100, 100));
            } else if (guess < randomNumber) {
                messageLabel.setText("⬆️ Too low! Try again.");
                messageLabel.setForeground(new Color(255, 215, 0)); // gold
            } else {
                messageLabel.setText("⬇️ Too high! Try again.");
                messageLabel.setForeground(new Color(255, 140, 0)); // orange
            }

            attemptLabel.setText("Attempts left: " + attemptsLeft);

            if (attemptsLeft == 0 && guess != randomNumber) {
                messageLabel.setText("❌ Out of attempts! Number was " + randomNumber);
                messageLabel.setForeground(Color.RED);
                guessButton.setEnabled(false);
                guessButton.setBackground(new Color(100, 100, 100));
            }

            guessField.setText("");
        } catch (NumberFormatException ex) {
            messageLabel.setText("⚠️ Enter a valid number!");
            messageLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModernNumberGuessingGame game = new ModernNumberGuessingGame();
            game.setVisible(true);
        });
    }

}
