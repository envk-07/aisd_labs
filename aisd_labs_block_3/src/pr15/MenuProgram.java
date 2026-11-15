package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuProgram extends JFrame {
    private JTextArea ta;

    public MenuProgram() {
        super("Программа с меню");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JMenuBar bar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выйти");
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Правка");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        helpMenu.add(aboutItem);

        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(helpMenu);
        setJMenuBar(bar);

        ta = new JTextArea("Введите текст здесь...");
        ta.setLineWrap(true);
        add(new JScrollPane(ta), BorderLayout.CENTER);

        JPanel pnl = new JPanel(new FlowLayout());
        JButton btn1 = new JButton("Кнопка 1");
        JButton btn2 = new JButton("Кнопка 2");
        pnl.add(btn1);
        pnl.add(btn2);
        add(pnl, BorderLayout.SOUTH);

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Файл сохранен!", "Сохранение", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Программа с меню. Версия 1.0", "О программе", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ta.append("\nНажата кнопка 1");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ta.append("\nНажата кнопка 2");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuProgram();
    }
}