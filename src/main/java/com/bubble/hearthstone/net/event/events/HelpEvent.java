package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;

public class HelpEvent implements IClientEvent {

    @Override
    public void process(GameManager manager) {
        manager.getGraphics().showHelp();
    }
}