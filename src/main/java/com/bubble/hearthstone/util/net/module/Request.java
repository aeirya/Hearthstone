package com.bubble.hearthstone.util.net.module;

public abstract class Request implements IRequest {
    protected int id;
    private ClientToken token;

    public void setID(int id) {
        this.id = id;
    }

    public void addToken(ClientToken token) {
        this.token = token;
    }

    public ClientToken getToken() {
        return token;
    }
}