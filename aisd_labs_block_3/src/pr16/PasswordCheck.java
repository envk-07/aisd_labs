package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordCheck extends JFrame {
    public PasswordCheck() {
        super("Проверка пароля");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblLogin = new JLabel("Логин:");
        JTextField tfLogin = new JTextField();

        JLabel lblPass = new JLabel("Пароль:");
        JPasswordField tfPass = new JPasswordField();

        JButton btn = new JButton("Войти");
        JLabel lblStatus = new JLabel(" ");

        add(lblLogin);
        add(tfLogin);
        add(lblPass);
        add(tfPass);
        add(btn);
        add(lblStatus);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = tfLogin.getText();
                String pass = new String(tfPass.getPassword());

                if (login.equals("admin") && pass.equals("12345")) {
                    lblStatus.setText("Успешный вход!");
                    lblStatus.setForeground(Color.GREEN);
                } else {
                    lblStatus.setText("Неверный логин или пароль");
                    lblStatus.setForeground(Color.RED);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PasswordCheck();
    }
}