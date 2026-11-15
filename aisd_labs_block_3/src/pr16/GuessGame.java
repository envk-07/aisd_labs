package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessGame extends JFrame {
    private int secret;
    private int attempts = 0;
    private JTextField tfGuess;
    private JLabel lblMsg;

    public GuessGame() {
        super("Игра-угадайка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        secret = (int)(Math.random() * 21);

        JPanel center = new JPanel(new FlowLayout());
        center.add(new JLabel("Угадайте число от 0 до 20:"));
        tfGuess = new JTextField(5);
        center.add(tfGuess);

        JButton btn = new JButton("Проверить");
        center.add(btn);

        lblMsg = new JLabel("Попыток осталось: 3");
        center.add(lblMsg);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attempts++;
                try {
                    int g = Integer.parseInt(tfGuess.getText().trim());
                    if (g == secret) {
                        JOptionPane.showMessageDialog(null, "Поздравляем! Вы угадали число " + secret, "Победа", JOptionPane.INFORMATION_MESSAGE);
                        btn.setEnabled(false);
                    } else if (attempts >= 3) {
                        JOptionPane.showMessageDialog(null, "Вы проиграли. Загаданное число: " + secret, "Проигрыш", JOptionPane.ERROR_MESSAGE);
                        btn.setEnabled(false);
                    } else {
                        String hint = (g < secret) ? "Больше" : "Меньше";
                        lblMsg.setText("Неверно. Подсказка: " + hint + ". Попыток осталось: " + (3 - attempts));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Введите число!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(center, BorderLayout.CENTER);

        add(makeRegion("Добро пожаловать в САО", "Север"), BorderLayout.NORTH);
        add(makeRegion("Добро пожаловать в ЗАО", "Запад"), BorderLayout.WEST);
        add(makeRegion("Добро пожаловать в ВАО", "Восток"), BorderLayout.EAST);
        add(makeRegion("Добро пожаловать в ЮАО", "Юг"), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel makeRegion(String msg, String name) {
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        p.add(new JLabel(name));

        p.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(null, msg, name, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return p;
    }

    public static void main(String[] args) {
        new GuessGame();
    }
}