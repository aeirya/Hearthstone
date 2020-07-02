package com.bubble.hearthstone.module.event;

public class EventSystem {

    private final EventManager eventManager;
    private final EventSystem instance;

    private EventSystem(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    

    public static void dispatch(IEvent event) {
        event.handle(event);
    }
}