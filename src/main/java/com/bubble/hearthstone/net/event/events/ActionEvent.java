package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.client.GameClient;

public class ActionEvent implements IClientEvent {
    private final GameAction action;

    public ActionEvent(GameAction action) {
        this.action = action;
    }

    @FunctionalInterface
    public interface GameAction{
        void act(GameClient client);
    }
    //coud've been replaced with a Cunsumer<GameManager>

    @Override
    public void process(GameClient client) {
        action.act(client);
    }
}