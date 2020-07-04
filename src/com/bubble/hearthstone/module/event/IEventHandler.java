package com.bubble.hearthstone.module.event;

public interface IEventHandler<T extends IEvent> {
    default void handle(T event) {
        event.process(this);
    }
}