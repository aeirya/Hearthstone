package com.bubble.hearthstone.net.event.events.login;

import com.bubble.hearthstone.net.client.GameClient;
import com.bubble.hearthstone.net.event.events.IClientEvent;
import com.bubble.hearthstone.util.services.ModuleLocator;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class ListPlayerEvent implements IClientEvent {

    // used by the cli
    @Override
    public void process(GameClient client) {
        final StringBuilder builder = new StringBuilder();
        ServiceLocator.getResources().getUsers().forEach(
            (string, user) -> builder.append("\n" + user.getUsername()
        ));
        ModuleLocator.getGraphics().message(builder.toString());
    }
    
}