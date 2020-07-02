package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventDispatcher;
import com.bubble.hearthstone.module.event.IEventHandler;

public class Arena implements IEventHandler, IEventDispatcher {

    private final IEventDispatcher eventSystem;

    public Arena(IEventDispatcher eventSystem) {
        this.eventSystem = eventSystem;
    }

    public Arena() {
        eventSystem = null;
    }

    public void startSession() {
        //
    }

    @Override
    public void handle(IEvent event) {
        event.process(this);
    }

    public void handle(IArenaEvent event) {
        event.process(this);
    }

    @Override
    public void dispatch(IEvent event) {
        eventSystem.dispatch(event);
    }
}