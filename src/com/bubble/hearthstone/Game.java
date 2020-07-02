package com.bubble.hearthstone;

import com.bubble.hearthstone.module.management.ModuleManager;

public class Game {
    
    private final ModuleManager modules;

    public Game() {
        modules = new ModuleManager();
    }

    public void start() {
        modules.start();
//        new Renderer().start();
    }
}