package com.bubble.hearthstone.input;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.gui.components.Frame;

public class GameInput implements IGameInput {

    private GameManager manager;
    private MouseInput mouseInput;

    // public GameInput(GameManager manager, IGameGraphics) {
    //     this.manager = manager;
    //     mouseInput = new MouseInput();
    //     mouseInput.bind(frame);
    // }

    private final IGameGraphics graphics;

    public GameInput(IGameGraphics graphics) {
        this.graphics = graphics;
    }

    public void triggerEvent(IGameEvent event) {
        sendEvent(event);
    }
    
    private void sendEvent(IGameEvent event) {
        manager.handleEvent(event);
    }

    @Override
    public MouseInput getMouseInput() {
        return mouseInput;
    }

    @Override
    public void bind(Frame frame) {
        mouseInput.bind(frame);
    }

    @Override
    public void start() {
        graphics.bind(this);
    }
}