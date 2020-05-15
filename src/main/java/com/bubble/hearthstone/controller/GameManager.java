package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.net.event.DummyNetworkEventQueue;
import com.bubble.hearthstone.net.event.INetworkEventQueue;
import com.bubble.hearthstone.net.event.EventHandler;
import com.bubble.hearthstone.net.event.GameEventHandler;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net.user.UserManager;
import com.bubble.hearthstone.util.services.ServiceLocator;

//will probably connect interfaces with event handler..
public class GameManager {
    
    private final UserManager userManager;
    private final EventHandler eventHandler;
    protected final INetworkEventQueue network;

    public GameManager() {
        userManager = new UserManager(this);
        eventHandler = new GameEventHandler(this, userManager).start();
        network = new DummyNetworkEventQueue();
    }

    public boolean login(String username, String password) {
        return userManager.login(username, password);
    }

    public boolean signup(String username, String password) {
        return userManager.signup(username, password);
    }

    public boolean deleteUser(String username, String password) {
        return userManager.deleteUser(username, password);
    }
    
    public void logout() {
        userManager.logout();
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

    public void networkPush(IGameEvent event) {
        network.push(event);
    }
}
