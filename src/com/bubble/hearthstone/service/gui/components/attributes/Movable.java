package com.bubble.hearthstone.client.service.gui.components.attributes;

import com.bubble.hearthstone.stl.Point;

public interface Movable {
    void setLocation(Point location);
    Point getLocation();
}