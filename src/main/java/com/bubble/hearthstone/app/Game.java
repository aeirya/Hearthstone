package com.bubble.hearthstone.app;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.controller.GuiManager;
import com.bubble.hearthstone.input.CliInput;
import com.bubble.hearthstone.input.IInput;
import com.bubble.hearthstone.interfaces.IGame;
import com.bubble.hearthstone.ui.GraphicsMode;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.util.services.ModuleLocator;
import com.bubble.hearthstone.util.services.ModuleManager;
import com.bubble.hearthstone.util.time.Waiter;

public class Game implements IGame {
    
    private final IGameGraphics graphics;
    private final GameManager manager;
    private final IInput input;
    private final ModuleManager moduleManager;
    private final GuiManager guiManager;

    Game(GraphicsMode graphicsMode) {
        moduleManager = new ModuleManager(graphicsMode);
        graphics = ModuleLocator.getGraphics();
        manager = new GameManager(graphics);
        input = new CliInput(manager, graphics);
        guiManager = new GuiManager(
            ModuleLocator.getGameInput(),
            ModuleLocator.getGraphics());
    }

    void start() {
        input.start();
    }

    void update() {
        manager.update();
        // graphics.update();
        Waiter.sleep();
        /*
         * player input
         * logic
         * render
         * exit checks
         * wait
         */
    }
}