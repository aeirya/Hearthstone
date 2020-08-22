package com.bubble.athena.server.lobby.chat;

import java.util.List;

import com.bubble.athena.server.lobby.IOnlineUserQuery;

public class ChatSystem {
    private final IOnlineUserQuery users;
    private final UserChatHistory history;

    public ChatSystem(IOnlineUserQuery users) {
        this.users = users;
        history = new UserChatHistory();
    }

    public boolean send(String from, String to, String msg, boolean isGlobal) {
        if (users.isOnline(to) || isGlobal) {
            history.commit(from, to, msg, isGlobal);
            return true;
        } else {
            return false;
        }
    }
    
    public List<String> getUserChat(String user) {
        return history.getUserChat(user);
    }

    public List<String> getGlobalChat() {
        return history.getGlobalChat();
    }
}