package com.bubble.hearthstone.app;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.interfaces.IGame;
import com.bubble.hearthstone.ui.Cli;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.SwingGraphics;
import com.bubble.hearthstone.util.time.Waiter;

public class Game implements IGame {
    
    private final IGameGraphics graphics;
    private final GameManager manager;
    
    Game(GraphicsMode graphicsMode) {
        manager = new GameManager();
        graphics = initiateGraphics(graphicsMode);
    }

    private IGameGraphics initiateGraphics(GraphicsMode graphicsMode) {
        if(graphicsMode == GraphicsMode.CLI) {
            return new Cli();
        } else return new SwingGraphics();
    }

    void start() {
        graphics.message("HI");
    }

    void update() {
        manager.update();
        graphics.update();
        Waiter.sleep();
        /*
         * player input
         * logic
         * render
         * exit checks
         * wait
         */
    }

    enum GraphicsMode {
        CLI, SWING
    }
}