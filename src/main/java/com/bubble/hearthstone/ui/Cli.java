package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.util.log.GameLogger;

public class Cli implements IInput, IGameGraphics {
    
    private final GameLogger logger;

    public Cli() {
        logger = new GameLogger();
    }

    public void out(String message) {
        logger.log(message);
    }

    public void update() {
        //
    }

    public void message(String message) {
        logger.log(message);
    }
}