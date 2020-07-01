package com.bubble.hearthstone.util.net.module;

public interface INetworkConnection {
    void push(IRequest request);
    IResponse get();
    boolean isAlive();
}