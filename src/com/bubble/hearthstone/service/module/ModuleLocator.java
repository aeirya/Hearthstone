package com.bubble.hearthstone.client.service.module;

import com.bubble.hearthstone.client.framework.network.INetwork;
import com.bubble.hearthstone.client.service.gui.GuiManager;
import com.bubble.hearthstone.client.service.render.IRenderer;

public class ModuleLocator {
    private INetwork network;
    private GuiManager gui;

    public ModuleLocator provideNetwork(INetwork network) {
        this.network = network;
        return this;
    }

    public INetwork getNetwork() {
        return network;
    }

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