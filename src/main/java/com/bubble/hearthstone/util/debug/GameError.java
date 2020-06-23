package com.bubble.hearthstone.util.debug;

import com.bubble.hearthstone.net.client.GameClient;
import com.bubble.hearthstone.net.event.events.IClientEvent;
import com.bubble.hearthstone.util.log.EventLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class GameError implements IClientEvent {
    private final String message;

    public GameError(String message) {
        this.message = message;
    }

    private void raise() {
        new EventLogger(
            ServiceLocator.getLogger(), null
        ).error(message);
    }

    @Override
    public void process(GameClient client) {
        raise();
    }
}