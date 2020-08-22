package com.bubble.athena.server.user;

public class User {
    public final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}