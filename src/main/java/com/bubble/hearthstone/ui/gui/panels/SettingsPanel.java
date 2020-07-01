package com.bubble.hearthstone.ui.gui.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingsPanel extends Panel {
    
    public SettingsPanel(JFrame frame) {
        super(frame);
        setup();
    }
    
    private void setup() {
        pane.setBackground(Color.CYAN);
        pane.add(new CenterBox());
    }

    private class CenterBox extends JPanel {

        CenterBox() {
            initiate();
        }

        private void initiate() {
            this.setPreferredSize(
                new Dimension(frame.getSize().width * 4 / 10, frame.getSize().height * 3 / 10));
            this.setBackground(pane.getBackground().darker());
            this.setup();
        }

        private void setup() {
            final Box box = Box.createVerticalBox();
            box.add(
                makeButton("Sound")
            );
            box.add(
                makeButton("Card Skin")
            );
            box.add(
                makeButton("Theme")
            );
            box.add(
                makeButton("Main Menu")
            );
            this.add(box);
        }

        private JButton makeButton(String name) {
            return makeButton(name, null);
        }

        private JButton makeButton(String name, ActionListener listener) {
            final JButton btn = new JButton(name);
            btn.setFont(
                new Font("SansSerif", Font.BOLD, 36));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.addActionListener(listener);
            return btn;
        }

        private static final long serialVersionUID = 1L;
    }
}