package pr5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    public Circle(Color color, int x, int y) {
        super(color, x, y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
    }
}

class RectangleFigure extends Shape {
    public RectangleFigure(Color color, int x, int y) {
        super(color, x, y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 40, 25);
    }
}

public class RandomShapes extends JFrame {
    private Shape[] shapes = new Shape[20];

    public RandomShapes() {
        super("20 случайных фигур");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            int x = rand.nextInt(450);
            int y = rand.nextInt(450);
            if (rand.nextBoolean()) {
                shapes[i] = new Circle(c, x, y);
            } else {
                shapes[i] = new RectangleFigure(c, x, y);
            }
        }

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < shapes.length; i++) {
                    shapes[i].draw(g);
                }
            }
        };
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomShapes();
    }
}