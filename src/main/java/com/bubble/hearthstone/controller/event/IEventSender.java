package com.bubble.hearthstone.controller.event;

import com.bubble.hearthstone.net.event.IGameEvent;

public interface IEventSender {
    void push(IGameEvent event);
}