package com.bubble.hearthstone.module.graphics;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.EventHandler;
import com.bubble.hearthstone.module.event.HandlerType;
import com.bubble.hearthstone.module.graphics.menu.IMenu;
import com.bubble.hearthstone.stl.Dimension;

@EventHandler(type = HandlerType.GRAPHICS)
public interface IGraphics extends IFramework {
    void launch(IMenu menu);
    void setWindowSize(Dimension size);
    Dimension getWindowSize();
}