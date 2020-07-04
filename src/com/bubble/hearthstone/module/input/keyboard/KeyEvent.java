package com.bubble.hearthstone.module.input.keyboard;

public class KeyEvent implements IKeyEvent {

    private final int key;
    private final KeyEventType type;

    public KeyEvent(int key, KeyEventType type) {
        this.key = key;
        this.type = type;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public KeyEventType getType() {
        return type;
    }
}