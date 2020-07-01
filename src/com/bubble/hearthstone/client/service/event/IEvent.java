package com.bubble.hearthstone.client.service.event;

public interface IEvent {
    void process(IEventHandler handler);
}