package com.bubble.hearthstone.input;

import com.bubble.hearthstone.net2.event.IGameEvent;

public interface ICommand {
    IGameEvent toEvent(String... args);
    String getDescription();
}