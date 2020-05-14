package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class SignupEvent implements IGameEvent {

    private final String username;
    private final String password;
    private String message;

    public SignupEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void process(GameManager manager) {
        final boolean result = manager.signup(username, password);
        message = setMessage(result);
    }

    private String setMessage(boolean result) {
        if (result)
            return "User [" + username + "] was registered";
        else return "User [" + username + "] could not register";
    }

    @Override
    public String getMessage() {
        return message;
    }
}