package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.user.UserManager;

/** login menu events will be extending this */
public abstract class UserManagerEvent implements IClientEvent {

    protected final String username;
    protected final String password;
    protected String message;

    public UserManagerEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract void process(UserManager userManager);

    public void process(GameManager manager) {
        this.process(manager.getUserManager());
    }
}