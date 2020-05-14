package com.bubble.hearthstone.net.user;

import java.util.HashMap;
import java.util.Map;

import com.bubble.hearthstone.util.log.MyFileWriter;
import com.bubble.hearthstone.util.serialize.UserSerializer;
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

    public void signup(String username, String password) {
        users.put(username, new User(username, password));
        createUserFile(username, password);
    }

    private void createUserFile(String username, String password) {
        new MyFileWriter(
            ServiceLocator.getResources().getResource("users")
            + username
            + ".json"
        ).write(
            new UserSerializer().serialize(
                new User(username, password)
            )
        );
    }

    public User getUser() {
        return current;
    }
}