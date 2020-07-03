package com.bubble.hearthstone.module.input;

import com.bubble.hearthstone.module.gui.GuiManager;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.mouse.IMouseInput;
import com.bubble.hearthstone.module.input.mouse.MouseInput;

public class GameInput implements IInput {
    
    private final IMouseInput mouseInput;
    private final GuiManager gui;

    public GameInput(GuiManager gui) {
        mouseInput = new MouseInput();
        this.gui = gui;
    }

    public IMouseInput getMouseInput() {
        return mouseInput;
    }

    @Override
    public void start() {
        bind(gui.getFrame());
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    public void bind(IFrame frame) {
        getMouseInput().bind(frame);
    }
}