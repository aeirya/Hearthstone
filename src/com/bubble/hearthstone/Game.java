package com.bubble.hearthstone;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventDispatcher;
import com.bubble.hearthstone.module.event.IEventHandler;
import com.bubble.hearthstone.module.logic.arena.Arena;
import com.bubble.hearthstone.module.management.ModuleManager;

public class Game implements IEventHandler {
    
    private final ModuleManager modules;
    private IEventHandler eventHandler;

    public Game() {
        modules = new ModuleManager(this);
    }

    public void start() {
        modules.start();
    }

    private void setEventHandler(IEventHandler handler) {
        this.eventHandler = handler;
    }

    public void launchArena() {
        Arena arena = new Arena();
        setEventHandler(arena);
        arena.startSession();
    }
}