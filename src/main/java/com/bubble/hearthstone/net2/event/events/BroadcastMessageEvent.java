package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class BroadcastMessageEvent implements IGameEvent {

    private final String message;

    public BroadcastMessageEvent(String message) {
        this.message = message;
    }

    public void process(GameManager manager) {
        manager.printBroadcastMessage(message);
    }
}