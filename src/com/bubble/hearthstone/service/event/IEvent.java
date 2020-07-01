package com.bubble.hearthstone.service.event;

public interface IEvent {
    void process(IEventHandler handler);
}