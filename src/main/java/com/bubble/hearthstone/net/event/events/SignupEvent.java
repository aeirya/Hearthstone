package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.registry.IUserManager;

public class SignupEvent extends UserEvent {

    private String message;

    public SignupEvent(User user) {
        super(user);
    }

    public SignupEvent(String username, String password) {
        super(username, password);
    }

    public void process(IUserManager manager) {
        final boolean result = manager.signup(username, password);
        message = setMessage(result);
    }

    private String setMessage(boolean result) {
        if (result)
            return "User [" + username + "] was registered";
        else
            return "User [" + username + "] could not register";
    }

    @Override
    public String getMessage() {
        return message;
    }
}