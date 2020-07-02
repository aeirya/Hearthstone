package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.module.gui.GuiManager;

public class ModuleLocator {
    private GuiManager gui;

    public IRenderer getRenderer() {
        return null;
    }

    public ModuleLocator provideGui(GuiManager gui) {
        this.gui = gui;
        return this;
    }

    public GuiManager getGui() {
        return gui;
    }
}