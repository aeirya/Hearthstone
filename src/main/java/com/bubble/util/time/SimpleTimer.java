package com.bubble.util.time;

public class SimpleTimer implements ITimer {

    private Time startTime;

    public SimpleTimer() {
        start();
    }

    /** starts fresh */
    public void start() {
        startTime = Time.now();
    }

    public Time getTimePassed() {
        return Time.now().delta(startTime);
    }
}