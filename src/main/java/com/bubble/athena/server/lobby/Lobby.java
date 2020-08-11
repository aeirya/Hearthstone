package com.bubble.athena.server.lobby;

import com.bubble.athena.server.user.IUserManager;
import com.bubble.net.server.INetwork;

public class Lobby implements ILobby {
    private final MatchFinder matchFinder;

    public Lobby(IUserManager usermanager, INetwork net) {
        matchFinder = new MatchFinder(usermanager, net);
    }

    @Override
    public void findMatch(String user) {
        matchFinder.queue(user);
    }
    
}