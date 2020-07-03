package com.bubble.hearthstone.module.event;

public interface IEventHandler {
    default void handle(IEvent event) {
        event.process(this);
    }
    default void handleEvent(IEvent event) {
        this.handle(event);
    }
}