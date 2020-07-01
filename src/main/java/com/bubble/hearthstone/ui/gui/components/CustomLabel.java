package com.bubble.hearthstone.ui.gui.components;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class CustomLabel extends JPanel {

    private static final long serialVersionUID = 1L;
    private final JLabel label;

    public CustomLabel(String text, Color backgroundColor) {
        label = new JLabel(text);
        this.setBackground(backgroundColor);
        this.add(label);
    }
    
    public CustomLabel(String text, Color backgroundColor, Color foregroundColor) {
        this(text, backgroundColor);
        label.setForeground(foregroundColor);
    }

    public CustomLabel(String text) {
        this(text, Color.DARK_GRAY);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        if (label != null) label.setFont(font);
    }
}