package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.model.Player;
import com.bubble.hearthstone.net.event.events.arena.ArenaEvent;
import com.bubble.hearthstone.util.time.ArenaTimer;

public class Arena {
    
    private final Player player;
    private final ArenaTimer timer;

    public Arena(Player player) {
        this.timer = new ArenaTimer();
        this.player = player;
    }

    void start() {
        timer.start();
    }

    public void handleEvent(ArenaEvent event) {
        event.process(this);
    }
}