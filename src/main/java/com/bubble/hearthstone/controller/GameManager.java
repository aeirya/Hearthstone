package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.net.event.DummyNetworkEventQueue;
import com.bubble.hearthstone.net.event.INetworkEventQueue;
import com.bubble.hearthstone.net.event.EventHandler;
import com.bubble.hearthstone.net.event.GameEventHandler;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net.event.events.DeleteUserEvent;
import com.bubble.hearthstone.net.event.events.LoginEvent;
import com.bubble.hearthstone.net.event.events.SignupEvent;
import com.bubble.hearthstone.net.user.UserManager;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class GameManager {
    
    private final UserManager userManager;
    private final EventHandler eventHandler;
    protected final INetworkEventQueue network;

    public GameManager() {
        userManager = new UserManager();
        eventHandler = new GameEventHandler(this, userManager).start();
        network = new DummyNetworkEventQueue();
        test();
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

    private void  test() {
        registerTest();
        loginTest();
        newUserTest();
        deleteUserTest();
    }

    private void registerTest() {
        network.push(
            new SignupEvent("aeirya", "123")
        );
        network.push(
            new SignupEvent("aeirya", "1234")
        );
    }

    private void loginTest() {
        network.push(
            new LoginEvent("aeirya", "123")
        );
        network.push(
            new LoginEvent("aeirya", "1234")
        );
    }

    private void newUserTest() {
        network.push(
            new SignupEvent("newUser", "newPassword")
        );
    }

    private void deleteUserTest() {
        network.push(
            new DeleteUserEvent("aeirya", "1234")
        );
        network.push(
            new DeleteUserEvent("aeirya", "123")
        );
    }
}
