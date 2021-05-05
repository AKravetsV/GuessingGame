import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessingGame extends JFrame {
    private JButton btnGuess;
    private JTextField txtGuess;
    private JLabel lblOutput;
    private JPanel panelMain;
    private JButton btnPlayAgain;
    static int theNumber;
    private int numberOfTries;

    public GuessingGame() {

        this.btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuessingGame.this.checkGuess();
            }
        });
        this.btnGuess.addKeyListener(new KeyAdapter() {
        });
        this.txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuessingGame.this.checkGuess();
            }
        });
        btnPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
    }

    public void checkGuess() {
        String guessText = this.txtGuess.getText();
        String message = "";
        numberOfTries++;

        try {
            int guess = Integer.parseInt(guessText);
            if (guess < theNumber) {
                message = guess + " is too low. Try again.";
            } else if (guess > theNumber) {
                message = guess + " is too high. Try again.";
            } else {
                message = guess + " is correct. You win after " + numberOfTries + " tries!";
                btnPlayAgain.setVisible(true);
            }
        } catch (Exception e) {
            message = "Enter a whole number between 1 and 10.";
        } finally {
            this.lblOutput.setText(message);
            this.txtGuess.requestFocus();
            this.txtGuess.selectAll();
        }
    }

    public void newGame() {
        theNumber = (int)(Math.random() * 10.0D + 1.0D);
        numberOfTries = 0;
        btnPlayAgain.setVisible(false);
        System.out.println(theNumber);
    }

    public static void main(String[] args) {
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setContentPane((new GuessingGame()).panelMain);
        theGame.setDefaultCloseOperation(3);
        theGame.setSize(new Dimension(550, 400));
        theGame.setVisible(true);
    }
}