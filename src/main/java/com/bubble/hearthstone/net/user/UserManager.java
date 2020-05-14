package com.bubble.hearthstone.net.user;

import java.util.HashMap;
import java.util.Map;

import com.bubble.hearthstone.util.services.ServiceLocator;

public class UserManager {

    private User current;
    private Map <String, User> users;

    public UserManager() {
        users = new HashMap<>();
        users = ServiceLocator.getResources().getUsers();
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