package com.bubble.hearthstone.module.event;

import com.bubble.hearthstone.module.management.ModuleLocator;
import com.bubble.hearthstone.stl.Queue;

public class EventManager {
    private final Queue<IEvent> queue;
    private final EventQueueOperator operator;
    
    private final IEventHandler handler;
    private final EventBus eventBus;

    public EventManager(ModuleLocator locator, EventBus eventBus) {
        queue = new Queue<>();
        operator = new EventQueueOperator(this);
        handler = initiateEventHandler(locator);
        this.eventBus = eventBus;
    }

    private GameEventHandler initiateEventHandler(ModuleLocator locator) {
        final GameEventHandler h = new GameEventHandler();
        h.register(HandlerType.GRAPHICS, locator.getGraphics());
        h.register(HandlerType.LOGIC, locator.getLogic());
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