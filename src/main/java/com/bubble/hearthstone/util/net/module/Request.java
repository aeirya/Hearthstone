package com.bubble.hearthstone.util.net.module;

public abstract class Request implements IRequest {
    protected int id;

    public void setID(int id) {
        this.id = id;
    }

    
}