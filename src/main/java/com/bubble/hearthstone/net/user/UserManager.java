package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.events.LoginEvent;
import com.bubble.hearthstone.net.event.events.LogoutEvent;
import com.bubble.hearthstone.util.log.EventLogger;
import com.bubble.hearthstone.util.log.IEventLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class UserManager {

    private User current;
    private UserSave save;
    private final Map<String, User> users;

    private final IEventLogger logger;
    private final GameManager gameManager;

    public static final User GLOBAL = new User("global", "");
    private static final User GUEST = new User("guest", "");

    public UserManager(GameManager gameManager) {
        users = ServiceLocator.getResources().getUsers();
        this.logger = new EventLogger(ServiceLocator.getLogger(), this);
        this.gameManager = gameManager;
        this.loginToGuest();
    }
    
    private void loginToGuest() {
        final String user = GUEST.getUsername();
        if (!exists(user)) signup(user, "");
        
        login(GUEST);
        logger.success("logged in as guest");
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
            login(user);
            return true;
        } else {
            logger.error("wrong password");
            return false;
        }
    }

    private void login(User user) {
        current = user;
        if (! user.equals(GUEST)) save = SaveManager.loadSave(user);
    }

    public boolean signup(String username, String password) {
        if (!exists(username)) {
            users.put(username, new User(username, password));
            createUserFile(username, password);
            if (current != null && ! current.equals(GUEST)) {
                gameManager.networkPush(new LogoutEvent(current.getUsername()));
            }
            gameManager.networkPush(
                new LoginEvent(username, password)
            );
            return true;
        } else {
            logger.error("user already exists");
            return false;
        }
    }

    private void createUserFile(String username, String password) {
        final User user = new User(username, password);
        SaveManager.createUserFile(user);
        SaveManager.createSaveFile(user);
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

    public void logout() {
        logger.error("logged out");
        loginToGuest();
    }

    public User getUser() {
        return current;
    }

    //TODO: move texts here
    private enum LogError {
        WRONG_PASSWORD,
        CANT_DELETE,
        DUPLICATE_USER,
        USER_NOT_EXIST,
    }
}