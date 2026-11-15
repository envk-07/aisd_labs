package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextEditor extends JFrame {
    private JTextArea ta;

    public TextEditor() {
        super("Редактор текста");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        ta = new JTextArea("Введите здесь ваш текст для тестирования.");
        ta.setLineWrap(true);
        add(new JScrollPane(ta), BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();

        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem redItem = new JMenuItem("Красный");
        JMenuItem blueItem = new JMenuItem("Синий");
        JMenuItem blackItem = new JMenuItem("Черный");
        colorMenu.add(redItem);
        colorMenu.add(blueItem);
        colorMenu.add(blackItem);

        JMenu fontMenu = new JMenu("Шрифт");
        JMenuItem timesItem = new JMenuItem("Times New Roman");
        JMenuItem msItem = new JMenuItem("MS Sans Serif");
        JMenuItem courierItem = new JMenuItem("Courier New");
        fontMenu.add(timesItem);
        fontMenu.add(msItem);
        fontMenu.add(courierItem);

        bar.add(colorMenu);
        bar.add(fontMenu);
        setJMenuBar(bar);

        ActionListener colorListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equals("Красный")) ta.setForeground(Color.RED);
                else if (cmd.equals("Синий")) ta.setForeground(Color.BLUE);
                else if (cmd.equals("Черный")) ta.setForeground(Color.BLACK);
            }
        };
        redItem.addActionListener(colorListener);
        blueItem.addActionListener(colorListener);
        blackItem.addActionListener(colorListener);

        ActionListener fontListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                Font f = ta.getFont();
                if (cmd.equals("Times New Roman")) {
                    ta.setFont(new Font("Times New Roman", f.getStyle(), f.getSize()));
                } else if (cmd.equals("MS Sans Serif")) {
                    ta.setFont(new Font("SansSerif", f.getStyle(), f.getSize()));
                } else if (cmd.equals("Courier New")) {
                    ta.setFont(new Font("Monospaced", f.getStyle(), f.getSize()));
                }
            }
        };
        timesItem.addActionListener(fontListener);
        msItem.addActionListener(fontListener);
        courierItem.addActionListener(fontListener);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}