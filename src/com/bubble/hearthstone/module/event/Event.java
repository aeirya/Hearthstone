package com.bubble.hearthstone.module.event;

public abstract class Event implements IEvent {

    protected final EventType type;

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }
}