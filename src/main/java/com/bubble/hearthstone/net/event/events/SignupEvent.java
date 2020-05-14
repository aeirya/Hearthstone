package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;

public class SignupEvent implements IGameEvent {

    private final String username;
    private final String password;

    public SignupEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void process(GameManager manager) {
        manager.signup(username, password);
    }

    @Override
    public String getMessage() {
        return "User [" + username + "] was registered";
    }
}