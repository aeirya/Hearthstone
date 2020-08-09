package com.bubble.hearthstone.net2.event;

import com.bubble.hearthstone.controller.GameManager;

public interface IGameEvent {
    void process(GameManager manager);
    
    default String getMessage() {
        return null;
    }
}