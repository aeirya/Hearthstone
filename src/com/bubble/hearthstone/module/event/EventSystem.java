package com.bubble.hearthstone.module.event;

public class EventSystem {

    private final EventManager eventManager;

    public EventSystem(EventManager eventManager) {
        this.eventManager = eventManager;
    }
    
    private static EventSystem instance;

    public static void start(EventSystem instance) {
        EventSystem.instance = instance;
    }

    public static EventSystem getInstance() {
        return instance;
    }

    public static void dispatch(IEvent event) {
        instance.eventManager.handle(event);
    }
}