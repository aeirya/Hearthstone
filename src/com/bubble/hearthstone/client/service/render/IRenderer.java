package com.bubble.hearthstone.client.service.render;

import com.bubble.hearthstone.client.framework.IFramework;
import com.bubble.hearthstone.client.service.gui.components.IComponent;

public interface IRenderer extends IFramework { 
    void render(IComponent component);
}