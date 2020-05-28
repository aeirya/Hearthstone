package com.bubble.hearthstone.ui.gui;

import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;

public interface IGuiComponent {
    void setSize(Dimension size);
    void setLocation(Point location);
}