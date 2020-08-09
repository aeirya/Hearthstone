package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class DeleteUserEvent implements IGameEvent {

    private final String username;
    private final String password;
    private String message;

    public DeleteUserEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void process(GameManager manager) {
        final boolean result = manager.deleteUser(username, password);
        message = setMessage(result);
    }

    private String setMessage(boolean result) {
        if (result) 
            return "User [" + username + "] was deleted";
        else return "User [" + username + "] could not be deleted";
    }

    @Override
    public String getMessage() {
        return message;
    }
}