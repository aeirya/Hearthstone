package com.bubble.hearthstone.module.input;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.gui.GuiManager;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.keyboard.IKeyboardInput;
import com.bubble.hearthstone.module.input.keyboard.KeyboardInput;
import com.bubble.hearthstone.module.input.mouse.IMouseInput;
import com.bubble.hearthstone.module.input.mouse.MouseInput;

public class GameInput implements IFramework {
    
    private final IMouseInput mouseInput;
    private final IKeyboardInput keyboardInput;
    private final GuiManager gui;

    public GameInput(GuiManager gui) {
        mouseInput = new MouseInput();
        keyboardInput = new KeyboardInput();
        this.gui = gui;
    }

    public IMouseInput getMouseInput() {
        return mouseInput;
    }

    public IKeyboardInput getKeyboardInput() {
        return keyboardInput;
    }

    @Override
    public void start() {
        bind(gui.getFrame());
    }

    @Override
    public void stop() {
        unbind();
    }

    public void bind(IFrame frame) {
        getMouseInput().bind(frame);
        getKeyboardInput().bind(frame);
    }

    private void unbind() {
        getMouseInput().unbind();
        getKeyboardInput().unbind();
    }
}