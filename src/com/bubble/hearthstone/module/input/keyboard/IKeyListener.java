package com.bubble.hearthstone.module.input.keyboard;

public interface IKeyListener {
    void onKeyPress(IKeyEvent event);
    void onKeyRelease(IKeyEvent event);
    void onKeyHold(IKeyEvent event);
}