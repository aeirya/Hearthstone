package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class DeleteUserEvent implements IGameEvent {

    public final String username;
    public final String password;

    public DeleteUserEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void process(GameManager manager) {
        manager.deleteUser(username, password);
    }

    @Override
    public String getMessage() {
        return "User [" + username + "] was deleted";
    }
}