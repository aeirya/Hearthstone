package com.bubble.hearthstone.module.event;

public class EventSystem {

    private final EventManager eventManager;
    private final EventBus eventBus;

    public EventSystem(EventManager eventManager) {
        this.eventManager = eventManager;
        // TODO: change this
        eventBus = null;
    }
    
    private static EventSystem instance;

    public static void start(EventSystem instance) {
        EventSystem.instance = instance;
    }

    public static EventSystem getInstance() {
        return instance;
    }

    public static void dispatch(IEvent event) {
        getInstance().eventManager.handle(event);
        // getInstance().eventBus.broadcast(event);
    }
}