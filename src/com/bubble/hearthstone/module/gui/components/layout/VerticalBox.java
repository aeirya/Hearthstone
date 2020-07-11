package com.bubble.hearthstone.module.gui.components.layout;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.module.gui.components.IComponent;
import com.bubble.hearthstone.module.gui.components.attributes.IContainer;
import com.bubble.hearthstone.stl.Point;

public class VerticalBox implements IContainer {

    private final List<IComponent> components;
    private Point lastAddedLocation;

    private VerticalBox() {
        components = new ArrayList<>();
    }

    public static Box create(IComponent... components) {
        Box box = null;
        box.add(components);
        return box;
    }

    @Override
    public void add(IComponent... components) {
        for (IComponent com : components) {
            add(com);
        }
    }

    private void add(IComponent component) {
        // get last added location
        components.add(component);
        // update last added location
    }
}