package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.net.user.registry.IUserManager;
import com.bubble.hearthstone.util.log.EventLogger;
import com.bubble.hearthstone.util.log.IEventLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

/** also logs event */
public class GameEventHandler extends EventHandler implements IEventLogger {

    private final EventLogger logger;

    public GameEventHandler(IEventProcessor manager, IUserManager userManager) {
        super(manager);
        this.logger = new EventLogger(ServiceLocator.getLogger(), userManager);
    }

    @Override
    protected void process(IGameEvent event) {
        event.process(processor);
        log(event);
    }
    
    public void log(IGameEvent event) {
        logger.log(event);
    }

    public void error(String error) {
        logger.error(error);
    }

    public void success(String message) {
        logger.success(message);
    }
}