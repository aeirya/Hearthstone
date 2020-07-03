package com.bubble.hearthstone.module.event;

public interface IEventHandler {
    default void handle(IEvent event) {
        event.process(this);
    }
}