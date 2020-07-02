package com.bubble.hearthstone;

import com.bubble.hearthstone.service.module.ModuleManager;

public class Game {
    
    private final ModuleManager modules;

    public Game() {
        modules = new ModuleManager();
    }

    public void start() {
        modules.start();
    }
}