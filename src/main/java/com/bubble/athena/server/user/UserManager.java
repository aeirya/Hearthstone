package com.bubble.athena.server.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.bubble.athena.server.database.Database;
import com.bubble.util.secure.PasswordDigest;
import com.google.gson.Gson;

public class UserManager implements IUserManager {

    private final Map<String, User> users;
    private final List<OnlineUser> onlineUsers;
    private static final String USERS_DIR = "users/";
    private final Logger logger;

    public UserManager() {
        logger = Logger.getLogger("usermanager");
        users = loadUsers();
        onlineUsers = new ArrayList<>();
    }
 
    private Map<String, User> loadUsers() {
        return Database.getAccountManager()
            .getAccounts()
            .stream()
            .map(account -> new User(account.getName(), account.getPassword()))
            .collect(Collectors.toMap(User::getName, Function.identity()));
    }

    @SuppressWarnings("all")
    @Deprecated
    private Map<String, User> loadUsersFromAssets() {
        createFolders();
        return new UserLoader().loadDir(USERS_DIR);
    } 

    private void createFolders() {
        final File path = new File(USERS_DIR);
        if (!path.exists()) {
            path.mkdir();
        }
    }

    private void createUser(User user) {
        users.put(user.username, user);
        saveUser(user);
        users.put(user.username, user);
    }

    @SuppressWarnings("all")
    @Deprecated
    private void saveUserIntoFile(User user) {
        try {
            Files.write(new File(USERS_DIR + user.username).toPath(), new Gson().toJson(user).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUser(User user) {
        Database.getAccountManager().create(user.getName(), user.getPassword());
    }

    public boolean signup(String username, String password) {
        if (users.containsKey(username)) return false;
        createUser(new User(username, encrypted(username, password)));
        return true;
    }

    private String encrypted(String username, String password) {
        return new PasswordDigest().generatePassword(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        if (! users.containsKey(username)) return false;
        if (! authenticate(username, password)) return false;
        if (onlineUsers.stream().anyMatch(user -> user.getUsername().equals(username))) {
            return false;
        }
        onlineUsers.add(new OnlineUser(username));
        logger.info(() -> username + " logged in");
        return true;
    }

    public boolean delete(String username, String password) {
        if (! users.containsKey(username)) return false;
        if (! authenticate(username, password)) return false;
        try {
            Files.delete(new File(USERS_DIR + username).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.remove(username);
        return true;
    }

    public boolean authenticate(String username, String password) {
        if (! users.containsKey(username)) return false;
        return users.get(username).authenticate(password);
    }

    public List<String> getOnlineUsers() {
        return onlineUsers.stream().map(OnlineUser::getUsername).collect(Collectors.toList());
    }
    
    public OnlineUser getOnlineUser(String username) {
        return onlineUsers
            .parallelStream()
            .filter(u-> u.getUsername().equals(username))
            .findAny()
            .orElse(null);
    }

    public boolean isOnline(String username) {
        return getOnlineUsers().contains(username);
    }

    public OnlineUser findUserWithAuth(String auth) {
        return onlineUsers.parallelStream()
            .filter(u -> u.getAuth().equals(auth))
            .findAny()
            .orElse(null);            
    }

    public boolean logout(String username, String password) {
        if (! authenticate(username, password)) return false;
        if (! isOnline(username)) return false; 
        onlineUsers.removeIf(u -> u.getUsername().equals(username));
        return true;
    }

    public Map<String, Boolean> getOnlineStatus() {
        return users.keySet().stream().collect(Collectors.toMap(Function.identity(), this::isOnline));
    }

    public Map<String, String> getUsersLobbyStatus() {
        return users.keySet().stream().collect(Collectors.toMap(Function.identity(), this::getStatus));
    }

    private String getStatus(String user) {
        if(isOnline(user)) {
            if(getOnlineUser(user).isInMatch()) {
                return "in match";
            }
            else {
                return "in lobby";
            }
        } else {
            return "offline";
        }
    }
}