package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class LoginEvent implements IGameEvent {

    public final String username;
    public final String password;
    private String message;

    public LoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void process(GameManager manager) {
        boolean result = manager.login(username, password);
        message = setMessage(result);
    }
    
    private String setMessage(boolean isSuccessful) {
        String msg = "User [" + username + "] ";
        if (isSuccessful) msg += "logged in successfully";
        else msg += "failed to log in ";
        return msg;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}