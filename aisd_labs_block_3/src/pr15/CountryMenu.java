package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryMenu extends JFrame {
    public CountryMenu() {
        super("Выбор страны");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setLayout(new FlowLayout());

        String[] countries = {"Выберите страну", "Франция", "Германия", "Япония"};
        JComboBox<String> combo = new JComboBox<>(countries);
        JLabel lblInfo = new JLabel("Информация будет здесь");

        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = (String) combo.getSelectedItem();
                if (s.equals("Франция")) {
                    lblInfo.setText("Франция: столица Париж, валюта Евро.");
                } else if (s.equals("Германия")) {
                    lblInfo.setText("Германия: столица Берлин, валюта Евро.");
                } else if (s.equals("Япония")) {
                    lblInfo.setText("Япония: столица Токио, валюта Иена.");
                } else {
                    lblInfo.setText("Информация будет здесь");
                }
            }
        });

        add(new JLabel("Страна:"));
        add(combo);
        add(lblInfo);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryMenu();
    }
}