package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;

public class GuiElement {
    public Point location;
    public Dimension size;
    public GuiElementType type;

    public enum GuiElementType {
        BUTTON, TEXT_FIELD, LABEL, PANEL, IMAGE
    }
}