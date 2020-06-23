package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GuiManager;
import com.bubble.hearthstone.net.client.GameClient;

public interface IGuiEvent extends IClientEvent {
    
    @Override
    default void process(GameClient client) {
        client.handleGuiEvent(this);
    }

    void process(GuiManager gui);
}