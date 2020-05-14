package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class LoginEvent implements IGameEvent {

    public final String username;
    public final String password;

    public LoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void process(GameManager manager) {
        boolean result = manager.login(username, password);
        onDone(result, manager);
    }
    
    private void onDone(boolean isSuccessful, GameManager manager) {
        String message = "User [" + username + "] ";
        if (isSuccessful) message += "logged in successfully";
        else message += "failed to log in ";
        manager.broadcast(message);
    }
}