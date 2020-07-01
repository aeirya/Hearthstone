package com.bubble.hearthstone.service.graphics;

import com.bubble.hearthstone.service.graphics.menu.IMenu;
import com.bubble.hearthstone.stl.Dimension;

public interface IGraphics {
    void launch(IMenu menu);
    void setWindowSize(Dimension size);
    Dimension getWindowSize();
}