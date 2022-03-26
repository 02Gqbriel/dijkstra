package ch.gabriel_egli.window;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ch.gabriel_egli.algorithm.IAlgorithm;

public class MainFrameView extends JFrame {
    private IAlgorithm algorithm;

    public MainFrameView() {
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void setAlgorithm(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setVisible() {
        super.setVisible(true);
    }
}