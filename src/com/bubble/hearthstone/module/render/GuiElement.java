package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.stl.Color;
import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;

public class GuiElement {
    public Point location;
    public Dimension size;
    public Color color;
    public GuiElementType type;

    public GuiElement(Point location, Dimension size, Color color, GuiElementType type) {
        this.location = location;
        this.size = size;
        this.color = color;
        this.size = size;
    }

    public enum GuiElementType {
        BUTTON, TEXT_FIELD, LABEL, PANEL, IMAGE
    }
}