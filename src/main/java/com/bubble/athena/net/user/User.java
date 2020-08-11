package com.bubble.athena.net.user;

public class User {
    public final String username;
    public final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
