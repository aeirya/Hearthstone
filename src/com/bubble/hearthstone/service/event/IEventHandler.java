package com.bubble.hearthstone.service.event;

public interface IEventHandler {
    void handle(IEvent event);
}