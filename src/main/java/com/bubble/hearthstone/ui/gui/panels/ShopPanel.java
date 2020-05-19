package com.bubble.hearthstone.ui.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ShopPanel extends Panel {

    private static final Color color = new Color(101, 42, 14);

    public ShopPanel(JFrame frame) {
        super(frame);
        pane.setBackground(color);
        initialize();
    }

    private void initialize() {
        pane.add(new CenterBox());
    }

    private class CenterBox extends JPanel {

        CenterBox() {
            this.setPreferredSize(new Dimension(frame.getWidth() * 3 / 4, frame.getHeight() * 3 / 4));
            this.setBackground(color.brighter());
            setup();
        }

        private void setup() {
            this.setLayout(new BorderLayout());
            this.add(new MenuBar(), BorderLayout.NORTH);
            this.add(new MainPanel(), BorderLayout.CENTER);
            this.add(new Tools(), BorderLayout.SOUTH);
        }

        private static final long serialVersionUID = 1L;
    }

    private class MainPanel extends JScrollPane {

        private final JPanel panel;

        MainPanel() {
            panel = new JPanel();
            setup();
        }

        private void setup() {
            panel.setBackground(this.getBackground());
            this.setViewportView(panel);
        }

        private static final long serialVersionUID = 1L;
    }

    private class MenuBar extends JPanel {

        private final JButton buyButton;
        private final JButton sellButton;

        MenuBar() {
            buyButton = new JButton("Buy");
            sellButton = new JButton("Sell");
            setup();
        }

        private void setup() {
            this.setBackground(color.darker());
            this.add(buyButton);
            this.add(sellButton);
        }

        private static final long serialVersionUID = 1L;
    }

    private class Tools extends JPanel {

        // filter buttons
        private final transient Map<String, ActionListener> filterBtnActions = Map.of("name", e -> {
        }, "mana", e -> {
        }, "hero", e -> {
        });

        private final LinkedHashMap<String, JButton> filterBtnMap;
        private final JTextField textField;
        private final JLabel filterByLabel;

        Tools() {
            filterBtnMap = filterBtnActions.keySet().stream().collect(Collectors.toMap(Function.identity(),
                    key -> makeButton(key, filterBtnActions.get(key)), (e1, e2) -> e1, LinkedHashMap::new));
            textField = filterTextField();
            filterByLabel = filterByLabel();
            setup();
        }

        private JButton makeButton(String text, ActionListener listener) {
            final JButton btn = new JButton();
            btn.setText(text);
            btn.addActionListener(listener);
            return btn;
        }

        private void setup() {
            this.setBackground(color.darker());
            final Box box = Box.createHorizontalBox();
            box.add(textField);
            box.add(Box.createRigidArea(new Dimension(25,0)));
            box.add(filterByLabel);
            filterBtnMap.values().forEach(box::add);
            this.add(box);
        }

        private JTextField filterTextField() {
            JTextField text = new JTextField();
            final String defaultText = "filter key";
            text.setText(defaultText);
            text.addFocusListener(new FocusListener() {
                    public void focusGained(FocusEvent e) {
                        text.setText("");
                    }
                    public void focusLost(FocusEvent e) {
                        //do nothing
                    }
                }
            );
            final Font font = new Font("Serif", Font.ITALIC, 22);
            text.setFont(font);
            text.setPreferredSize(new Dimension(175, 0));
            return text;
        }

        private JLabel filterByLabel() {
            final JLabel label = new JLabel();
            label.setText("filter by: ");
            label.setForeground(Color.WHITE);
            return label;
        }

        private static final long serialVersionUID = 1L;
    }
}