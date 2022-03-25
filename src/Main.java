import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Window extends JFrame {
    private final int width;
    private final int height;

    public static void main(String[] args) {
        new Window(900, 900, "Dijkstra Algorithmus");
    }

    public Window(int width, int height, String title) {
        super(title);

        this.height = height;
        this.width = width;

        init();

        setVisible(true);
    }

    private void init() {
        this.setSize(width, height);
        this.setResizable(false);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setJMenuBar(new Menu());
    }

    class Menu extends JMenuBar {
        public Menu() {
            this.setPreferredSize(new Dimension(200, 35));
            JMenu item = new JMenu("Settings");
            Border bo = new LineBorder(Color.blue);
            item.setBorder(bo);

            item.add(new JMenuItem("Help"));

            this.add(item);

            this.addMouseListener(new MouseLis);
        }
    }
}

class Node {
    private int x;
    private int y;
    private String title;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, String title) {
        this.x = x;
        this.y = y;
        this.title = title;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
