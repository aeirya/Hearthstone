package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.client.GameClient;
import com.bubble.hearthstone.util.services.ModuleLocator;

public class HelpEvent implements IClientEvent {

    @Override
    public void process(GameClient client) {
        ModuleLocator.getGraphics().showHelp();
    }
}