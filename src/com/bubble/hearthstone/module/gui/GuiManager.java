package com.bubble.hearthstone.module.gui;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.render.glfw.WindowManager;
import com.bubble.hearthstone.module.service.ServiceLocator;
import com.bubble.hearthstone.stl.Dimension;
import com.bubble.hearthstone.util.config.GameConfig;

public class GuiManager implements IFramework {

    private final WindowManager windowManager;

    public GuiManager() {
        windowManager = new WindowManager();
    }

    @Override
    public void start() {
        windowManager.start();
        setFramesize();
    }

    public void setFramesize() {
        final GameConfig config = ServiceLocator.getResources().getGameConfig();
        final Dimension size = config.getResolution();
        getFrame().setSize(size);
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
        return windowManager.getFrame();
    }

    public void update() {
        windowManager.update();
    }
}