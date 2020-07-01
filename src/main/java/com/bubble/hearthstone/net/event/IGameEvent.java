package com.bubble.hearthstone.net.event;

public interface IGameEvent {

    void process(IEventProcessor processor);

    default String getMessage() {
        return null;
    }
}