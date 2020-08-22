package com.bubble.hearthstone.net2.event;

public interface INetworkEventQueue {
    IGameEvent get();
    void push(IGameEvent event);
}