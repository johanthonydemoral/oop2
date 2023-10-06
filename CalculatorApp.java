import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculatorApp extends JFrame {

    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton clearButton;
    private JButton equalsButton;
    private double num1, num2, result;
    private char operator;

    public CalculatorApp() {

        setTitle(" Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());


        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");

        clearButton = new JButton("C");
        equalsButton = new JButton("=");

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[0]);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[1]);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[2]);
        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(operationButtons[3]);

        add(displayField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);


        for (int i = 0; i < 10; i++) {
            int digit = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    displayField.setText(displayField.getText() + digit);
                }
            });
        }

        for (int i = 0; i < 4; i++) {
            char op;
            switch (i) {
                case 0:
                    op = '+';
                    break;
                case 1:
                    op = '-';
                    break;
                case 2:
                    op = '*';
                    break;
                case 3:
                    op = '/';
                    break;
                default:
                    op = ' ';
            }
            operationButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    num1 = Double.parseDouble(displayField.getText());
                    operator = op;
                    displayField.setText("");
                }
            });
        }

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
            }
        });

        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(displayField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            displayField.setText("Error");
                            return;
                        }
                        break;
                }
                displayField.setText(String.valueOf(result));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp().setVisible(true);
            }
        });
    }
}
