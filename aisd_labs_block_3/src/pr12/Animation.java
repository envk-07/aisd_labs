package pr12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Animation extends JFrame {
    private int frame = 0;
    private String[] names = {"Кадр 1", "Кадр 2", "Кадр 3"};
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private JLabel lbl;

    public Animation() {
        super("Анимация");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        lbl = new JLabel(names[0], JLabel.CENTER);
        lbl.setOpaque(true);
        lbl.setBackground(colors[0]);
        lbl.setPreferredSize(new Dimension(250, 150));
        add(lbl);

        Timer t = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame = (frame + 1) % names.length;
                lbl.setText(names[frame]);
                lbl.setBackground(colors[frame]);
            }
        });
        t.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Animation();
    }
}