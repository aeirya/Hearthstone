package com.bubble.athena.server.lobby.chat;

import java.util.List;

import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.server.INetwork;

public class ChatSystem {
    private final INetwork net;
    private final IUserManager users;
    private final ChatHistory history;

    public ChatSystem(IUserManager users, INetwork net) {
        this.net = net;
        this.users = users;
        history = new ChatHistory();
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