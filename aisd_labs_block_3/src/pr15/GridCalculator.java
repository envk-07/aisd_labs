package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridCalculator extends JFrame {
    private JTextField display;
    private double first = 0;
    private String op = "";
    private boolean startNew = true;

    public GridCalculator() {
        super("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel pnl = new JPanel();
        pnl.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
                    if (startNew) {
                        display.setText(cmd);
                        startNew = false;
                    } else {
                        display.setText(display.getText() + cmd);
                    }
                } else if (cmd.equals("C")) {
                    display.setText("0");
                    first = 0;
                    op = "";
                    startNew = true;
                } else if (cmd.equals("=")) {
                    calculate();
                } else {
                    first = Double.parseDouble(display.getText());
                    op = cmd;
                    startNew = true;
                }
            }
        };

        for (int i = 0; i < buttons.length; i++) {
            JButton b = new JButton(buttons[i]);
            b.setFont(new Font("Arial", Font.BOLD, 20));
            b.addActionListener(listener);
            pnl.add(b);
        }

        add(pnl, BorderLayout.CENTER);
        setVisible(true);
    }

    private void calculate() {
        double second = Double.parseDouble(display.getText());
        double result = 0;

        try {
            if (op.equals("+")) result = first + second;
            else if (op.equals("-")) result = first - second;
            else if (op.equals("*")) result = first * second;
            else if (op.equals("/")) {
                if (second == 0) {
                    JOptionPane.showMessageDialog(this, "Деление на ноль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = first / second;
            }
            display.setText(String.valueOf(result));
            startNew = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GridCalculator();
    }
}