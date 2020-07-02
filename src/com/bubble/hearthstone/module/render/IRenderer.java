package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.framework.IFramework;
import com.bubble.hearthstone.service.gui.components.IComponent;

public interface IRenderer extends IFramework { 
    void render(IComponent component);
}