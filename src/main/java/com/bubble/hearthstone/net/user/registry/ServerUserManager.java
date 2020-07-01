package com.bubble.hearthstone.net.user.registry;

import java.util.Map;

import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.IUserEvent;
import com.bubble.hearthstone.net.server.IGameServer;
import com.bubble.hearthstone.net.server.events.user.errors.NoSuchUserError;
import com.bubble.hearthstone.net.server.events.user.errors.WrongPasswordError;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.net.user.registry.requests.UserRequest;
import com.bubble.hearthstone.net.user.registry.users.Users;
import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class ServerUserManager implements IServerUserManager {

    private final Map<String, User> users;
    private final IGameServer server;

    public ServerUserManager(IGameServer server) {
        this.server = server;
        users = ServiceLocator.getResources().getUsers();
    }

    public void handleEvent(IUserEvent event) {
        event.process(this);
    }

    public void handleRequest(UserRequest request) {
        request.process(this);
    }

    public ClientToken getClientToken(String username, String password) {
        return null;
    }

    /*
     * raise double login error disconnection?
     */

    @Override
    public boolean login(String username, String password) {
        if (!exists(username)) {
            sendEvent(new NoSuchUserError());
            return false;
        }
        final User user = users.get(username);
        if (user.authenticate(password)) {
            login(user);
            return true;
        } else {
            sendEvent(new WrongPasswordError());
            return false;
        }
    }

    private void login(User user) {
        //
    }

    @Override
    public boolean signup(String username, String password) {
        
        return true;
    }

    @Override
    public boolean delete(String username, String password) {
        // TODO Auto-generated method stub
        return true;

    }

    @Override
    public boolean logout(String username, String password) {
        // TODO Auto-generated method stub
        return true;

    }

    private boolean exists(String username) {
        return users.containsKey(username);
    }

    @Override
    public void sendEvent(IGameEvent event) {
        ServiceLocator
            .getNetworkService()
            .push(event);
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (exists(username)){
            return users.get(username).authenticate(password);
        }
        return false;
    }

    public User getMe() {
        return Users.SERVER;
    }
}