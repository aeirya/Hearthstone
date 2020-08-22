package com.bubble.athena.server.lobby;

import java.util.List;

public interface ILobby {
    void findMatch(String user);
    boolean sendMessage(String from, String to, String msg, boolean isGlobal);
    List<String> getGlobalChat();
    List<String> getUserChat(String user);

    void addFriend(String me, String user);
}