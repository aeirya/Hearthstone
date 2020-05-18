package com.bubble.hearthstone.app;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.input.CliInput;
import com.bubble.hearthstone.input.IInput;
import com.bubble.hearthstone.interfaces.IGame;
import com.bubble.hearthstone.ui.Cli;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.SwingGraphics;
import com.bubble.hearthstone.util.time.Waiter;

public class Game implements IGame {
    
    private final IGameGraphics graphics;
    private final GameManager manager;
    private final IInput input;
    
    Game(GraphicsMode graphicsMode) {
        graphics = initiateGraphics(graphicsMode, manager);
        manager = new GameManager();
        input = new CliInput(manager, graphics);
    }

    private IGameGraphics initiateGraphics(GraphicsMode graphicsMode, GameManager manager) {
        if(graphicsMode == GraphicsMode.CLI) {
            return new Cli(); //not using manager
        } else return new SwingGraphics(manager); //passing the manager to subclasses for now..
    }

    void start() {
        input.start();
    }

    void update() {
        manager.update();
        // graphics.update();s
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