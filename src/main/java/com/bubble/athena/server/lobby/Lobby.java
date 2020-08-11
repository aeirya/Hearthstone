package com.bubble.athena.server.lobby;

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
    public void sendMessage(String from, String to, String msg) {
        chat.send(from, to, msg);
    }
    
}