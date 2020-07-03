package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.encode.EncodedUser;
import com.bubble.hearthstone.util.encode.UserEncoder;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public EncodedUser encode() {
        return new UserEncoder().encode(username, password);
    }
}