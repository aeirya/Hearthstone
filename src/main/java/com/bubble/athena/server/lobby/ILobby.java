package com.bubble.athena.server.lobby;

public interface ILobby {
    void findMatch(String user);
    void sendMessage(String from, String to, String msg);
}