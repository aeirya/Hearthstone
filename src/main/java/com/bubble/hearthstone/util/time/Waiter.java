package com.bubble.hearthstone.util.time;

public class Waiter {

    private static final int FPS = 2; //TODO: hardcored
    
    private Waiter() { }

    public static void sleep() {
        try {
            Thread.sleep(1000 / FPS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}