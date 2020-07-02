package com.bubble.hearthstone.module.gui;

import java.util.HashMap;
import java.util.Map;

import com.bubble.hearthstone.module.gui.components.IComponent;
import com.bubble.hearthstone.stl.Point;

public class SceneLayout {
    private final Map<IComponent, Point> layout;

    public SceneLayout() {
        layout = new HashMap<>();
    }
}