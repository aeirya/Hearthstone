package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class Cli implements IGameGraphics {
    
    private final GameLogger logger;

    public Cli() {
        logger = ServiceLocator.getLogger();
    }

    public void update() {
        //
    }

    public void message(String message) {
        logger.log(message);
    }

    public void error(String message) {
        logger.warning(message);
    }
}