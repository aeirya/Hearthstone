package com.bubble.hearthstone.util.time;

public class ArenaTimer {
    private final GameTimer playerTimer;

    public ArenaTimer() {
        playerTimer = new GameTimer();
    }

    public void start() {
        playerTimer.start();
    }

    public Time getPlayerTime() {
        return playerTimer.getTimePassed();
    }
}