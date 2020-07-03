package com.bubble.hearthstone.module.logic.arena;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventDispatcher;
import com.bubble.hearthstone.module.event.IEventHandler;

public class Arena implements IEventHandler, IEventDispatcher {

    private final Player player1;
    private final Player player2;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startSession() {
        //
    }

    @Override
    public void handle(IEvent event) {
        event.process(this);
    }

    public void handle(IArenaEvent event) {
        event.process(this);
    }

    @Override
    public void dispatch(IEvent event) {
        EventSystem.dispatch(event);
    }
}