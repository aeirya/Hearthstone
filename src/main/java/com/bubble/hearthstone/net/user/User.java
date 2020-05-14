package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.serialize.UserSerializer;

public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean exists() {
        //to be implemented
        return false;
    }

    boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public String getEncodedPassword() {
        return new UserEncodder().getEncoddedPassword();
    }

    private class UserEncodder {
        public String getEncoddedPassword() {
            return encode(password);
        }

        private String encode(String word) {
            return word;
        }
    }
}