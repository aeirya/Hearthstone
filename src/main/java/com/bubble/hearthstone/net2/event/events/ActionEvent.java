package com.bubble.hearthstone.net2.event.events;

import com.bubble.hearthstone.controller.GameManager;

public class ActionEvent implements IClientEvent {
    private final GameManagerAction action;

    public ActionEvent(GameManagerAction action) {
        this.action = action;
    }

    @FunctionalInterface
    public interface GameManagerAction{
        void act(GameManager manager);
    }
    //coud've been replaced with a Cunsumer<GameManager>

    @Override
    public void process(GameManager manager) {
        action.act(manager);
    }
}