package com.bubble.hearthstone.module;

import com.bubble.hearthstone.message.IMessageHandler;

public interface IFramework extends IMessageHandler {
    void start();
    void stop();
    void handleMessage(Object message);
}