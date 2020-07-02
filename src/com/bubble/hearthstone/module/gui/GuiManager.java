package com.bubble.hearthstone.module.gui;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.render.glfw.WindowManager;

public class GuiManager implements IFramework {

    private final WindowManager windowManager;
    private final IFrame window;

    public GuiManager() {
        windowManager = new WindowManager();
        window = windowManager.getFrame();
    }

    @Override
    public void start() {
        windowManager.start();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void handle(IEvent event) {
        // TODO Auto-generated method stub
    }

    public IFrame getFrame() {
        return window;
    }
}