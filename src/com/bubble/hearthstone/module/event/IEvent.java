package com.bubble.hearthstone.module.event;

public interface IEvent {
    EventType getType();
    void process(IEventHandler handler);
}