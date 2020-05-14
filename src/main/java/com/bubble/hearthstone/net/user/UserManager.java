package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.util.log.EventLogger;
import com.bubble.hearthstone.util.log.IEventLogger;
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

    private final IEventLogger logger;

    public UserManager() {
        users = new HashMap<>();
        users = ServiceLocator.getResources().getUsers();
        this.logger = new EventLogger(ServiceLocator.getLogger(), this);

        this.loginToGuest();
    }
    
    private void loginToGuest() {
        final String user = "guest";
        if (!exists(user)) signup(user, "");
        login(user, "");
    }

    private boolean exists(String username) {
        return users.containsKey(username);
    }

    public boolean login(String username, String password) {
        if (!exists(username)) {
            logger.error("no such user exists");
            return false;
        }
        final User user = users.get(username);
        if (user.authenticate(password)) {
            current = user;
            return true;
        } else {
            logger.error("wrong passwrd");
            return false;
        }
    }

    public boolean signup(String username, String password) {
        if (!exists(username)) {
            users.put(username, new User(username, password));
            createUserFile(username, password);
            return true;
        } else {
            logger.error("user already exists");
            return false;
        }
    }

    private void createUserFile(String username, String password) {
        final User user = new User(username, password);
        new MyFileWriter(user.getFilePath()).write(new UserSerializer().serialize(user));
    }

    public boolean deleteUser(String username, String password) {
        if (exists(username)) {
            final User user = users.get(username);
            if (user.authenticate(password)) {
                users.remove(username);
                try {
                    Files.delete(
                        Paths.get(user.getFilePath())
                        );
                    return true;
                } catch (IOException e) {
                    logger.error("couldn't delete it..");
                }
            } else {
                logger.error("wrong password :p");
            }
            if (current.getUsername().equals(username)) logout();
        } else {
            logger.error("the user you're trying to delete doesn't exist.. yet!");
        }
        return false;
    }

    private void logout() {
        login("guest", "");
    }

    public User getUser() {
        return current;
    }
}