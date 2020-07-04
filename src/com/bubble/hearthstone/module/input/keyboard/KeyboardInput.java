package com.bubble.hearthstone.module.input.keyboard;

import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.keyboard.glfw.GlfwKeyboardInput;

public class KeyboardInput implements IKeyboardInput {

    private final IKeyboardInput input;

    public KeyboardInput() {
        input = new GlfwKeyboardInput(this);
    }

    @Override
    public void bind(IFrame frame) {
        input.bind(frame);
    }

    @Override
    public void onKeyPress(IKeyEvent event) {
        System.out.println("pressed "+ event.getKey());
    }

    @Override
    public void onKeyRelease(IKeyEvent event) {
        System.out.println("released " + event.getKey());
    }

    @Override
    public void onKeyHold(IKeyEvent event) {
        System.out.println("held "+ event.getKey());
    }
    
}