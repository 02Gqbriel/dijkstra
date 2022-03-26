package ch.gabriel_egli.algorithm;

import java.awt.Canvas;
import java.util.HashMap;

public interface IAlgorithm {

    public HashMap getSettings();

    public Object getSetting(String key);

    public void setSetting(String key, Object value);

    public Canvas getCanvas();
}
