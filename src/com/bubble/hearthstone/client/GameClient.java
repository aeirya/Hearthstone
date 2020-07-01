package com.bubble.hearthstone.client;

import com.bubble.hearthstone.client.service.module.ModuleManager;

public class GameClient implements IGameClient {
    private final ModuleManager modules;
    private final 
    public GameClient() {
        modules = new ModuleManager();
    }

    public void run() {
        modules.start();
    }
}