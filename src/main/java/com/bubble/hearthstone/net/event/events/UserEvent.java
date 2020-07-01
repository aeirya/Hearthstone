package com.bubble.hearthstone.net.event.events;

import com.bubble.hearthstone.net.user.User;

public abstract class UserEvent implements IUserEvent {

    protected final String username;
    protected final String password;

    public UserEvent(User user) {
        this.username = user.getUsername();
        this.password = user.getEncodedPassword();
    }

    // use this
    public UserEvent(String username, String password) {
        this.username = username;
        this.password = password;
    }
}