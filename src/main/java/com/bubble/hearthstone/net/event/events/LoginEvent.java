package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.ui.MenuType;

public class LoginEvent implements IGameEvent {

    private final String username;
    private final String password;
    private String message;

    public LoginEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void process(GameManager manager) {
        boolean result = manager.login(username, password);
        message = setMessage(result);
        //you can lunch main menu now :p
        if (result) manager.lunch(MenuType.MAIN);
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