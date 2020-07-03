package com.bubble.hearthstone.module.event;

public interface IEventHandler {
    default void handle(IEvent event) {
        System.out.println("A");
        event.process(this);
    }
}