package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.module.IFramework;

import com.bubble.hearthstone.module.gui.components.IComponent;

public interface IRenderer extends IFramework { 
    void render(IComponent component);
    void update();
}