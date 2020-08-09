package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.controller.GameManager;

public interface IGameEvent {
    void process(GameManager manager);
    
    default String getMessage() {
        return null;
    }
}