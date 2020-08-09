package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.services.ServiceLocator;

public class User {
    private final String username;
    private final transient String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getFilePath() {
        return ServiceLocator.getResources().getResource("users")
            + username
            + ".json";
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return this.getUsername();
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