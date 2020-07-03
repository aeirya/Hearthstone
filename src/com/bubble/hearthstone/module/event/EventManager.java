package com.bubble.hearthstone.module.event;

import com.bubble.hearthstone.module.management.ModuleLocator;
import com.bubble.hearthstone.stl.Queue;

public class EventManager {
    private final Queue<IEvent> queue;
    private final EventQueueOperator operator;
    
    private final IEventHandler handler;
    private final EventBus eventBus;

    public EventManager(ModuleLocator modules, EventBus eventBus) {
        queue = new Queue<>();
        operator = new EventQueueOperator(this);
        handler = initiateEventHandler(modules);
        this.eventBus = eventBus;
    }

    private GameEventHandler initiateEventHandler(ModuleLocator modules) {
        final GameEventHandler h = new GameEventHandler();
        h.register(HandlerType.GRAPHICS, modules.getGraphics());
        h.register(HandlerType.LOGIC, modules.getLogic());
        // h.register(HandlerType.USER, services.getUserManager());
        return h;
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
        queue.push(event);
    }

    /** @return null is non existant */
    IEvent nextEvent() {
        if (queue.hasNext()) {
            return queue.next();
        }
        else return null;
    }
}