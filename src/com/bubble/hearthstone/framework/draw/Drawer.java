package com.bubble.hearthstone.framework.draw;

import com.bubble.hearthstone.service.gui.components.IComponent;
import com.bubble.hearthstone.service.gui.components.IFrame;

public class Drawer implements IComponentDrawer {

    //swap this with a map
    private final FrameDrawer frameDrawer;

    private static class InstanceHolder {
        private static final Drawer instance = new Drawer();
    }

    public static Drawer getInstance() {
        return InstanceHolder.instance;
    }

    private Drawer() { 
        frameDrawer = new FrameDrawer();
    }

    public void draw(IComponent component) {
        if (component instanceof IFrame) {
            frameDrawer.draw(component);
        }
    }

    public static void drawComponent(IComponent component) {
        drawComponent(component);
    }
}