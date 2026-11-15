package pr12;

import javax.swing.*;

public class ImageViewer extends JFrame {
    public ImageViewer(String path) {
        super("Просмотр изображения");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(path);
        JLabel label = new JLabel(icon);

        if (icon.getIconWidth() <= 0) {
            label.setText("Изображение не найдено: " + path);
        }

        add(label);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageViewer("C:/123.jpg");
    }
}