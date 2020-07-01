package com.bubble.hearthstone.util.services;

import com.bubble.hearthstone.input.IGameInput;
import com.bubble.hearthstone.ui.IGameGraphics;

public class ModuleLocator {
    
    private IGameGraphics graphics;
    private IGameInput input;

    private static class InstanceHolder {
        private static final ModuleLocator instance = new ModuleLocator();
    }

    static ModuleLocator getInstance() {
        return InstanceHolder.instance;
    }

    private ModuleLocator() { }

    ModuleLocator provideGraphics(IGameGraphics graphics) {
        this.graphics = graphics;
        return this;
    }

    public static IGameGraphics getGraphics() {
        return getInstance().graphics;
    }

    ModuleLocator provideGameInput(IGameInput input) {
        this.input = input;
        return this;
    }

    public static IGameInput getGameInput() {
        return getInstance().input;
    }
}