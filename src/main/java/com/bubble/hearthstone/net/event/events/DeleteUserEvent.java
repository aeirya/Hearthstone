package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.registry.IUserManager;

public class DeleteUserEvent extends UserEvent {

    private String message;

    public DeleteUserEvent(User user) {
        super(user);
    }

    public DeleteUserEvent(String username, String password) {
        super(username, password);
    }

    @Override
    public void process(IUserManager manager) {
        final boolean result = manager.delete(username, password);
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