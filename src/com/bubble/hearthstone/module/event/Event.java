package com.bubble.hearthstone.module.event;

public abstract class Event implements IEvent {

    protected final EventType type;
    private boolean isCancelled;

    public Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }

    public void cancel() {
        isCancelled = true;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}