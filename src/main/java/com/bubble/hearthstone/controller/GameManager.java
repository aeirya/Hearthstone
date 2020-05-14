package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.net.event.DummyNetworkEventQueue;
import com.bubble.hearthstone.net.event.INetworkEventQueue;
import com.bubble.hearthstone.net.event.EventHandler;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net.user.UserManager;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class GameManager {
    
    private final UserManager userManager;
    private final EventHandler eventHandler;
    private final INetworkEventQueue network;

    public GameManager() {
        userManager = new UserManager();
        eventHandler = new EventHandler(this);
        network = new DummyNetworkEventQueue();
    }

    public boolean login(String username, String password) {
        return userManager.login(username, password);
    }

    public void printBroadcastMessage(String message) {
        ServiceLocator.getLogger().log("broadcast message: " + message);
    }

    public void broadcast(String message) {
        network.push(
            new BroadcastMessageEvent(message)
        );
    }

    public void update() {
        //i guess i should start using threads
        final IGameEvent event = network.get();
        eventHandler.receive(event);
    }
}
