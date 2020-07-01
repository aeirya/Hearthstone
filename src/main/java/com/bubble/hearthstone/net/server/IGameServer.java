package com.bubble.hearthstone.net.server;

import com.bubble.hearthstone.net.event.IEventProcessor;
import com.bubble.hearthstone.net.event.events.IUserEvent;
import com.bubble.hearthstone.net.event.events.arena.IArenaEvent;
import com.bubble.hearthstone.util.net.module.ClientToken;
import com.bubble.hearthstone.util.net.module.IResponse;

public interface IGameServer extends IEventProcessor {
    void handleUserEvent(IUserEvent event);
    void handleArenaEvent(IArenaEvent event);
    void respond(IResponse response, ClientToken token);
}