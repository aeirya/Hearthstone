package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.log.EventLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

/** also logs event */
public class GameEventHandler extends EventHandler {

    private final EventLogger logger;

    public GameEventHandler(GameManager manager, User user) {
        super(manager);
        this.logger = new EventLogger(ServiceLocator.getLogger(), user);
    }

    @Override
    protected void process(IGameEvent event) {
        event.process(manager);
        logger.log(event);
    }
}