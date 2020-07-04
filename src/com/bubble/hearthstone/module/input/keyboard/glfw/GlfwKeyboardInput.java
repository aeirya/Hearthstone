package com.bubble.hearthstone.module.input.keyboard.glfw;

import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.keyboard.IKeyEvent;
import com.bubble.hearthstone.module.input.keyboard.IKeyListener;
import com.bubble.hearthstone.module.input.keyboard.IKeyboardInput;
import com.bubble.hearthstone.module.input.keyboard.KeyEvent;
import com.bubble.hearthstone.module.input.keyboard.IKeyEvent.KeyEventType;
import com.bubble.hearthstone.module.render.glfw.WindowFrame;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class GlfwKeyboardInput implements IKeyboardInput {

    private GLFWKeyCallback keyCallback = new GLFWKeyCallback(){
        @Override
        public void invoke(long window, int key, int scancode, int action, int mods) {
            handleKeyEvent(
                new KeyEvent(key, getType(action))
            );
        }
    };

    private final IKeyListener listener;

    public GlfwKeyboardInput(IKeyListener listener) {
        this.listener = listener;
    }

    private void handleKeyEvent(IKeyEvent event) {
        switch (event.getType()) {
            case PRESS:
            onKeyPress(event);
            break;
            case RELEASE:
            onKeyRelease(event);
            break;
            case HOLD:
            onKeyHold(event);
            break;
        }

    }

    private KeyEventType getType(int action) {
        switch(action) {
            case GLFW.GLFW_PRESS:
            return KeyEventType.PRESS;
            case GLFW.GLFW_RELEASE:
            return KeyEventType.RELEASE;
            case GLFW.GLFW_REPEAT:
            return KeyEventType.HOLD;
            default:
            return null;
        }
    }

    @Override
    public void bind(IFrame frame) {
        if (frame instanceof WindowFrame) {
            ((WindowFrame) frame).bind(this);
        }
    }

    public void bind(long window) {
        keyCallback.set(window);
    }

    public void unbind() {
        keyCallback.set(0);
    }

    @Override
    public void onKeyPress(IKeyEvent event) {
        listener.onKeyPress(event);
    }

    @Override
    public void onKeyRelease(IKeyEvent event) {
        listener.onKeyRelease(event);
    }

    @Override
    public void onKeyHold(IKeyEvent event) {
        listener.onKeyHold(event);
    }
    
}