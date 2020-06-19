package com.bubble.hearthstone.util.net.module;

public class ClientToken {

    private final int clientID;

    public ClientToken(int clientID) {
        this.clientID = clientID;
    }

    public int getID() {
        return clientID;
    }
}