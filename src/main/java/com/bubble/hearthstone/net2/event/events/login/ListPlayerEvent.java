package com.bubble.hearthstone.net2.event.events.login;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net2.event.events.IClientEvent;

public class ListPlayerEvent implements IClientEvent {

    // used by the cli
    @Override
    public void process(GameManager manager) {
        final StringBuilder builder = new StringBuilder();
        manager.getUserManager().getUsers().forEach(
            u -> builder.append("\n" + u.getUsername())
        );
        manager.message(builder.toString());
    }
    
}