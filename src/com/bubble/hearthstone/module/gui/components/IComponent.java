package com.bubble.hearthstone.module.gui.components;

import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.stl.Point;

public interface IComponent {
    void setSize(Dimension size);
    void setLocation(Point location);
}