package com.bubble.athena.server.user;

import com.bubble.util.secure.PasswordDigest;

public class User {
    public final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(new PasswordDigest().generatePassword(username, password));
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}