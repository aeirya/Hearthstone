package com.bubble.hearthstone;

public class Hearthstone implements Runnable {
    
    private final String config;

    public static void main(String... args) {
        new Hearthstone(args).run();
    }

    public Hearthstone(String[] args) {
        if (args.length > 0) {
            config = args[0];
        }
        else config = "config/files.properties";
    }

    public void run() {
        new Game().start();
    }
}