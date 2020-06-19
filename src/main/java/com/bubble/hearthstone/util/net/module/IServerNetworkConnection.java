package com.bubble.hearthstone.util.net.module;

public interface IServerNetworkConnection {
    void push(IResponse response);
    IRequest get();
}