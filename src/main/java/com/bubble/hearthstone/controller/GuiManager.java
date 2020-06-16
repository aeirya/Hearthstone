package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.input.IGameInput;
import com.bubble.hearthstone.stl.Point;
import com.bubble.hearthstone.ui.IGameGraphics;

public class GuiManager implements Runnable {
    
    private final IGameInput gameInput;
    private final IGameGraphics graphics;

    public GuiManager(IGameInput gameInput, IGameGraphics graphics) {
        this.gameInput = gameInput;
        this.graphics = graphics;
    }

    public void start() {
        new Thread(this::run).start();
    }

    public void run() {
        
        gameInput.start();

        while (true) {
            //
            break;
        }
    }

    private Point getMouseLocation() {
        return gameInput.getMouseInput().getMouseLocation();
    }
}