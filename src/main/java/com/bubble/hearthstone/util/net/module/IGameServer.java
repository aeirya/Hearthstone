package com.bubble.hearthstone.util.net.module;

import com.bubble.hearthstone.net2.event.events.UserEvent;

public interface IGameServer {
    void handleUserEvent(UserEvent event);
    void respond(IResponse response);
}