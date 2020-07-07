package com.bubble.hearthstone.module.gui.components.layout;

import com.bubble.hearthstone.module.gui.components.IComponent;

public class VerticalBox {
    public static Box create(IComponent... components) {
        Box box = null;
        box.add(components);
        return box;
    }
}