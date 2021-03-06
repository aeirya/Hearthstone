package com.bubble.athena.server.user;

import java.util.Map;

import com.bubble.athena.server.lobby.IOnlineUserQuery;

public interface IUserManager extends IOnlineUserQuery {
    boolean login(String username, String password);
    boolean signup(String username, String password);
    boolean delete(String username, String password);
    boolean authenticate(String username, String password);
    boolean logout(String username, String password);
    
    OnlineUser findUserWithAuth(String auth);
    
    OnlineUser getOnlineUser(String username);
    boolean isOnline(String username);
    
    Map<String, Boolean> getOnlineStatus();
    Map<String, String> getUsersLobbyStatus();
}