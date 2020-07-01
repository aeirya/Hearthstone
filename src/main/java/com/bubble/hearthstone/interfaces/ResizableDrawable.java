package com.bubble.hearthstone.interfaces;

import java.awt.Dimension;

public interface ResizableDrawable extends Drawable {
    void setSize(Dimension size);
    void setLocation(int x, int y);
}