package com.bubble.hearthstone.module.input;

import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.mouse.IMouseInput;
import com.bubble.hearthstone.module.input.mouse.MouseInput;

public class GameInput implements IInput {
    
    private final IMouseInput mouseInput;
    private final IFrame frame;

    public GameInput(IFrame frame) {
        mouseInput = new MouseInput();
        this.frame = frame;
    }

    public IMouseInput getMouseInput() {
        return mouseInput;
    }

    @Override
    public void start() {
        bind(frame);
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    public void bind(IFrame frame) {
        getMouseInput().bind(frame);
    }
}