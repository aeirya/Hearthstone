package com.bubble.athena.server.lobby;

import java.util.Map;

import com.bubble.athena.server.user.OnlineUser;

public interface IOnlineUserQuery {
    boolean isOnline(String user);
    OnlineUser getOnlineUser(String user);

    Map<String, Boolean> getOnlineStatus();
    Map<String, String> getUsersLobbyStatus();
}