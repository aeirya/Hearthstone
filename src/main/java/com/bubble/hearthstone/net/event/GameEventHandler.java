package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

/** also logs event */
public class GameEventHandler extends EventHandler {

    private GameLogger logger;

    public GameEventHandler(GameManager manager) {
        super(manager);
    }

    @Override
    protected void initialize() {
        logger = ServiceLocator.getLogger();
        super.initialize();
    }

    @Override
    protected void process(IGameEvent event) {
        event.process(manager);
        final String message = event.getMessage();
        if (message != null) logger.logEvent(message);
    }
}