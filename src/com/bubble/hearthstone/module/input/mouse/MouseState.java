package com.bubble.hearthstone.module.input.mouse;

import com.bubble.hearthstone.stl.Point;

public class MouseState {
    public final Point location;
    public final boolean isMoved;

    public MouseState(Point location, boolean isMoved) {
        this.location = location;
        this.isMoved = isMoved;
    }
}