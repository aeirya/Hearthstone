package com.bubble.hearthstone;

import com.bubble.hearthstone.module.event.EventBus;
import com.bubble.hearthstone.module.event.EventHandler;
import com.bubble.hearthstone.module.management.ModuleManager;

public class Game {
    
    private final ModuleManager modules;
    private final EventBus events;

    public Game() {
        modules = new ModuleManager();
    }

    public void start() {
        modules.start();
    }
}