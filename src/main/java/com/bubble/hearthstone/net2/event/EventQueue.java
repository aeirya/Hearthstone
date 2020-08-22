package com.bubble.hearthstone.net2.event;

import java.util.LinkedList;

public class EventQueue {
    
    private final LinkedList<IGameEvent> events;

    public EventQueue() {
        this.events = new LinkedList<>();
    }

    public void push(IGameEvent event) {
        events.add(event);
        //later in the game : broadcast(Event)
    }

    public IGameEvent next() {
        return this.events.removeFirst();
    }

    public boolean isFree() {
        return events.isEmpty();
    }
}