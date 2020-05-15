package com.bubble.hearthstone.input;

import com.bubble.hearthstone.net.event.IGameEvent;

public interface ICommand {
    IGameEvent toEvent(String... args);
    String getDescription();
}