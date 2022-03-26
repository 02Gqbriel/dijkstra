package ch.gabriel_egli.window;

import ch.gabriel_egli.algorithm.IAlgorithm;

import java.awt.Dimension;

public class MainFrameModel {
    private int width;
    private int height;
    private String title;
    private IAlgorithm algorithm;

    public MainFrameModel(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public MainFrameModel(int width, int height, String title) {
        this(width, height);

        this.title = title;
    }

    public Dimension getSize() {
        return new Dimension(width, height);
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return IAlgorithm return the algorithm
     */
    public IAlgorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * @param algorithm the algorithm to set
     */
    public void setAlgorithm(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * @return int return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return int return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

}
