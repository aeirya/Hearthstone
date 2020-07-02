package com.bubble.hearthstone.module;

import com.bubble.hearthstone.module.event.IEventHandler;

public interface IFramework extends IEventHandler {
    void start();
    void stop();
}