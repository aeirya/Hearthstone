package com.bubble.athena.server.lobby;

import java.util.List;

import com.bubble.athena.server.lobby.chat.ChatSystem;
import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.server.INetwork;

public class Lobby implements ILobby {
    private final MatchFinder matchFinder;
    private final ChatSystem chat;

    public Lobby(IUserManager usermanager, INetwork net) {
        chat = new ChatSystem(usermanager, net);
        matchFinder = new MatchFinder(usermanager, net);
    }

    @Override
    public void findMatch(String user) {
        matchFinder.queue(user);
    }

    @Override
    public boolean sendMessage(String from, String to, String msg, boolean isGlobal) {
        return chat.send(from, to, msg, isGlobal);
    }
    
    public List<String> getGlobalChat() {
        return chat.getGlobalChat();
    }

    @Override
    public List<String> getUserChat(String user) {
        return chat.getUserChat(user);
    }
}