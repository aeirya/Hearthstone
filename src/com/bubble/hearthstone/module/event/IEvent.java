package com.bubble.hearthstone.module.event;

public interface IEvent {
    void process(IEventHandler handler);
}