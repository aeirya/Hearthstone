package com.bubble.util.time;


public class GameTimer implements IGameTimer {

    private final Thread thread;
    private final ITimer currentTimer;
    private boolean isPaused;
    private boolean isStopped;
    private Time accTime;
    private Time timePassed;

    public GameTimer() {
        isPaused = false;
        isStopped = false;
        currentTimer = new SimpleTimer();
        thread = new Thread(this::check, "GameTimer");
    }

    public void start() {
        currentTimer.start();
        thread.start();
    }

    public void stop() {
        isStopped = true;
    }

    private void check() {
        while (!isStopped) {
            if (!isPaused) {
                timePassed = currentTimer.getTimePassed();
            } else {
                synchronized(this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void pause() {
        accTime = getTimePassed();
        timePassed = null;
        isPaused = true;
    }

    public void resume() {
        currentTimer.start();
        isPaused = false;
        synchronized(this) {
            notifyAll();
        }   
    }

    public Time getTimePassed() {
        return timePassed.sum(accTime);
    }
}