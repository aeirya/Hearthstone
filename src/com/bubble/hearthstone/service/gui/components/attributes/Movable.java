package com.bubble.hearthstone.service.gui.components.attributes;

import com.bubble.hearthstone.stl.Point;

public interface Movable {
    void setLocation(Point location);
    Point getLocation();
}