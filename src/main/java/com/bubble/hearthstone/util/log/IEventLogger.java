package com.bubble.hearthstone.util.log;

import com.bubble.hearthstone.net.event.IGameEvent;

public interface IEventLogger {
    void log(IGameEvent event);
    void error(String message);
    void success(String message);
}