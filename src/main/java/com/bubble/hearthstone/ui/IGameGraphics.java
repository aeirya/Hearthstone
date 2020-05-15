package com.bubble.hearthstone.ui;

import com.bubble.hearthstone.interfaces.Updatable;

public interface IGameGraphics extends Updatable {
    /**
     * maybe:
     *  use LWJGL 3
     */    
    void message(String message);
    void error(String message);
}