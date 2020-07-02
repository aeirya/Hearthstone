package com.bubble.hearthstone.module.event;

import com.bubble.hearthstone.stl.Queue;

public class EventManager {
    private final IEventHandler handler;
    private final Queue<IEvent> eventQueue;
    private final EventOperator operator;

    public EventManager() {
        eventQueue = new Queue<>();
        operator = new EventOperator(this);
        handler = new EventHandler();
    }

    public void start() {
        operator.start();
    }

    // handling 
    public void handle(IEvent event) {
        handler.handle(event);
    }

    // queue
    public void receive(IEvent event) {
        eventQueue.push(event);
    }

    /** @return null is non existant */
    IEvent nextEvent() {
        if (eventQueue.hasNext()) {
            return eventQueue.next();
        }
        else return null;
    }
}