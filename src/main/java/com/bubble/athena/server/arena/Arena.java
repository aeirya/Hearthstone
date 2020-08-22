package com.bubble.athena.server.arena;

import com.bubble.athena.net.arena.IArenaEvent;
import com.bubble.util.time.GameTimer;
import com.bubble.util.time.IGameTimer;
import com.bubble.util.time.Time;

public class Arena implements IArena {
    private IGameTimer timer;
    private IRulebook rules;
    private Game game;

    public Arena(Game game) {
        this.game = game;
        timer = new GameTimer();
    }

    public void start() {
        timer.start();
    }

    public Time getTimePassed() {
        return timer.getTimePassed();
    }

    @Override
    public void handle(IArenaEvent event) {
        event.test();
    }
}