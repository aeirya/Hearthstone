package com.bubble.hearthstone.net.event;

public interface INetworkEventQueue {
    IGameEvent get();
    void push(IGameEvent event);
}