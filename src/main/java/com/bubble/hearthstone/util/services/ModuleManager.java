package com.bubble.hearthstone.util.services;

import com.bubble.hearthstone.input.GameInput;
import com.bubble.hearthstone.input.IGameInput;
import com.bubble.hearthstone.ui.Cli;
import com.bubble.hearthstone.ui.GraphicsMode;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.SwingGraphics;

public class ModuleManager {

    private final IGameGraphics graphics;
    private final IGameInput input;

    public ModuleManager(GraphicsMode graphicsMode) {
        graphics = initiateGraphics(graphicsMode);
        input = initiateInput(graphics);
        initateModuleLocator();
    }

    private void initateModuleLocator() {
        ModuleLocator.getInstance()
            .provideGraphics(graphics)
            .provideGameInput(input);
    }

    private IGameGraphics initiateGraphics(GraphicsMode graphicsMode) {
        if(graphicsMode == GraphicsMode.CLI) {
            return new Cli(); //not using manager
        } else return new SwingGraphics(); //passing the manager to subclasses for now..
    }

    private IGameInput initiateInput(IGameGraphics graphics) {
        return new GameInput(graphics);
    }
}