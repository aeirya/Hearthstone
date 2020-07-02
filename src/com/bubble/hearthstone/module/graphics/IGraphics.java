package com.bubble.hearthstone.module.graphics;

import com.bubble.hearthstone.module.graphics.menu.IMenu;
import com.bubble.hearthstone.stl.Dimension;

public interface IGraphics {
    void launch(IMenu menu);
    void setWindowSize(Dimension size);
    Dimension getWindowSize();
}