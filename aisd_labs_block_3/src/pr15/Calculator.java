package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField tf1 = new JTextField(10);
    private JTextField tf2 = new JTextField(10);
    private JLabel lblResult = new JLabel("Результат: ");

    public Calculator() {
        super("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Число 1:"));
        add(tf1);
        add(new JLabel("Число 2:"));
        add(tf2);

        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");

        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);
        add(lblResult);

        ActionListener calc = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(tf1.getText().trim());
                    double x2 = Double.parseDouble(tf2.getText().trim());
                    double res = 0;
                    String op = e.getActionCommand();

                    if (op.equals("+")) res = x1 + x2;
                    else if (op.equals("-")) res = x1 - x2;
                    else if (op.equals("*")) res = x1 * x2;
                    else if (op.equals("/")) {
                        if (x2 == 0) {
                            JOptionPane.showMessageDialog(null, "Деление на ноль!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        res = x1 / x2;
                    }
                    lblResult.setText("Результат: " + res);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Введите числа!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        btnAdd.addActionListener(calc);
        btnSub.addActionListener(calc);
        btnMul.addActionListener(calc);
        btnDiv.addActionListener(calc);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}