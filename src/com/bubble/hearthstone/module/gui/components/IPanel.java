package com.bubble.hearthstone.module.gui.components;

import com.bubble.hearthstone.module.gui.components.attributes.IContainer;

public interface IPanel extends IContainer {
    void addComponent(IComponent component);
    void addComponents(IComponent... component);
}