package com.bubble.hearthstone.module.graphics;

import com.bubble.hearthstone.module.graphics.menu.IMenu;
import com.bubble.hearthstone.module.graphics.menu.IMenuLauncher;
import com.bubble.hearthstone.module.graphics.menu.MenuType;
import com.bubble.hearthstone.module.gui.GuiManager;
import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.stl.Dimension;

public class OpenGlGraphics implements IGraphics {

    private final IRenderer renderer;
    private final GuiManager gui;
    private final IMenuLauncher launcher;

    public OpenGlGraphics(IRenderer renderer, GuiManager gui) {
        this.renderer = renderer;
        this.gui = gui;
        launcher = null;
    }

    @Override
    public void setWindowSize(Dimension size) {
        // TODO Auto-generated method stub

    }

    @Override
    public Dimension getWindowSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void start() {
        //
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void launch(MenuType menu) {
        launcher.launch(menu);
    }

    @Override
    public void load(IMenu menu) {
        //
    }
    
}