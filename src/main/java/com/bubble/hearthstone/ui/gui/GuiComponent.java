package com.bubble.hearthstone.ui.gui;

import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;

public class GuiComponent implements IGuiComponent {
    private Point location;
    private Dimension size;

    public GuiComponent() {
        this(null, null);
    }

    public GuiComponent(Point location, Dimension size) {
        this.location = location;
        this.size = size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Dimension getSize() {
        return size;
    }

    public Point getLocation() {
        return location;
    }
}