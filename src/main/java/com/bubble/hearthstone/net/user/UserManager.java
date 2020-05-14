package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.log.MyFileWriter;
import com.bubble.hearthstone.util.serialize.UserSerializer;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private User current;
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
        users = ServiceLocator.getResources().getUsers();
    }

    private boolean exists(String username) {
        return users.containsKey(username);
    }

    public boolean login(String username, String password) {
        if (!exists(username)) {
            //no such user exists
            return false;
        }
        final User user = users.get(username);
        if (user.authenticate(password)) {
            current = user;
            // log login
            return true;
        } else {
            // broadcaster.broadcast("wrong password :p");
            return false;
        }
    }

    public void signup(String username, String password) {
        if (!exists(username)) {
            users.put(username, new User(username, password));
            createUserFile(username, password);
        } else { /* user already exists */ }
    }

    private void createUserFile(String username, String password) {
        final User user = new User(username, password);
        new MyFileWriter(user.getFilePath()).write(new UserSerializer().serialize(user));
    }

    public void deleteUser(String username, String password) {
        if (exists(username)) {
            final User user = users.get(username);
            if (user.authenticate(password)) {
                users.remove(username);
                try {
                    Files.delete(
                        Paths.get(user.getFilePath())
                        );
                } catch (IOException e) {
                    // broadcaster.broadcast("couldn't delete it..")
                }
            } else {
                //broadcaster.broadcast("wrong password :p")
            }
            if (current.getUsername().equals(username)) logout();
        } else {
            //the user you're trying to delete doesn't exist.. yet!
        }
    }

    private void logout() {
        //do nothing
        this.current = null;
        //login to local guest
    }

    public User getUser() {
        return current;
    }
}