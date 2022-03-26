package ch.gabriel_egli.window;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class EntryFrame extends JFrame {
    private HashMap<String, Component> windowSettingsMap = new HashMap<String, Component>() {
        {
            put("Width: ", new JTextArea());
            put("Height: ", new JTextArea());
            put("Title: ", new JTextArea());
        }
    };

    private HashMap<String, Component> algoSettingsMap = new HashMap<String, Component>() {
        {
            put("Algorithm: ", new JTextArea());
        }
    };

    // Submit Section
    private final JPanel submitPanel = new JPanel();
    private final JPanel settingsPanel = new JPanel();

    public EntryFrame() {
        super("Einstellungen");

        init();

        setupSubmitSection();

        setupSection("Window Einstellungen", windowSettingsMap);
        setupSection("Algorithm Einstellungen", algoSettingsMap);

        this.setVisible(true);
    }

    private void init() {
        this.setSize(350, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(5, 5));
        this.setResizable(false);
    }

    private void setupSubmitSection() {
        submitPanel.setLayout(new BorderLayout());

        Border border = submitPanel.getBorder();
        Border margin = new EmptyBorder(5, 5, 5, 5);
        submitPanel.setBorder(new CompoundBorder(border, margin));

        final JButton button = new JButton("Weiter");
        submitPanel.add(button, BorderLayout.EAST);

        this.add(submitPanel, BorderLayout.SOUTH);
    }

    private void setupSection(String title, Map<String, Component> map) {
        final JPanel windowPanel = new JPanel();
        int size = map.size();
        windowPanel.setBorder(new TitledBorder(new LineBorder(Color.black), title));
        windowPanel.setPreferredSize(new Dimension(335, size == 1 ? 40 : size * 32));
        windowPanel.setLayout(new GridLayout(map.size(), 1, 10, 10));

        map.forEach((k, v) -> {
            windowPanel.add(setupSettingPanel(k, v));

            if (v instanceof JTextArea) {
                JTextArea v2 = (JTextArea) v;
                v2.setBorder(new LineBorder(Color.black));
                v2.addKeyListener(new KeyAdapter() {

                    @Override
                    public void keyReleased(KeyEvent e) {
                        int len = v2.getText().length();

                        if (e.getKeyChar() == '\n') {
                            v2.setText(v2.getText().replaceAll("\n", ""));
                        }

                        if (len > 3 && (k.equalsIgnoreCase("Width: ") || (k.equalsIgnoreCase("Height: ")))) {
                            char[] le = v2.getText().toCharArray();
                            String res = "";
                            for (int i = 0; i < 3; i++) {
                                res += le[i];
                            }

                            v2.setText(res);
                            JOptionPane.showMessageDialog(windowPanel,
                                    "Breite darf nicht grösser als 1920 sein!\nHöhe darf nicht grösser als 1080 sein!",
                                    "Error",
                                    JOptionPane.WARNING_MESSAGE);

                        }
                        super.keyReleased(e);
                    }

                });
            }
        });

        settingsPanel.add(windowPanel);
        settingsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(settingsPanel, BorderLayout.CENTER);
    }

    private JPanel setupSettingPanel(String label, Component comp) {
        JPanel _p = new JPanel(), p = new JPanel();
        JLabel l = new JLabel(" " + label + "   ");

        _p.setLayout(new GridLayout(0, 1));
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

        p.add(l);
        p.add(comp);
        p.add(new JLabel(" "));

        _p.add(p);

        return _p;
    }
}
