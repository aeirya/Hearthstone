package com.bubble.hearthstone.net.user;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private User current;
    private Map <String, User> users;

    public UserManager() {
        users = new HashMap<>();
        users.put("aeirya", new User("aeirya", "123"));
    }

    public boolean login(String username, String password) {
        final User user = users.get(username);
        if (user.authenticate(password)) {
            current = user;
            //log login
            return true;
        } else return false;
    }

    public User getUser() {
        return current;
    }
}