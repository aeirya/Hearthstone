package com.bubble.hearthstone.server.framework;

import com.bubble.hearthstone.client.service.event.IEvent;

public interface IFramework {
    void start();
    void stop();
    void handle(IEvent event);
}