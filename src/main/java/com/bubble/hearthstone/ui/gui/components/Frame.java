package com.bubble.hearthstone.ui.gui.components;

import javax.swing.JFrame;

import com.bubble.hearthstone.stl.Dimension;

public class Frame {
    private final JFrame jframe;

    public Frame(JFrame frame) {
        this.jframe = frame;
    }

    public Dimension getSize() {
        final java.awt.Dimension size = jframe.getSize();
        return new Dimension(size.width, size.height);
    }
}