package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.controller.GameManager;

@FunctionalInterface
public interface IGameEvent {
    void process(GameManager manager);
}