package com.bubble.hearthstone.network;

import com.bubble.hearthstone.client.service.event.IEventDispatcher;

public interface INetworkConnection extends IEventDispatcher {
    void start();
}