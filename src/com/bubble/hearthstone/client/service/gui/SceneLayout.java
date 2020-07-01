package com.bubble.hearthstone.client.service.gui;

import java.util.HashMap;
import java.util.Map;

import com.bubble.hearthstone.client.service.gui.components.IComponent;
import com.bubble.hearthstone.stl.Point;

public class SceneLayout {
    private final Map<IComponent, Point> layout;

    public SceneLayout() {
        layout = new HashMap<>();
    }
}