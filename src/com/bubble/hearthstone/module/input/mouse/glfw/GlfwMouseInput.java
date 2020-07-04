package com.bubble.hearthstone.module.input.mouse.glfw;

import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.mouse.IMouseInput;
import com.bubble.hearthstone.module.input.mouse.IMouseListener;
import com.bubble.hearthstone.module.input.mouse.MouseState;
import com.bubble.hearthstone.module.render.glfw.WindowFrame;
import com.bubble.hearthstone.stl.Point;

import org.lwjgl.glfw.GLFWCursorPosCallback;

public class GlfwMouseInput implements IMouseInput {

    private final IMouseListener listener;

    private final GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback() {
        @Override
        public void invoke(long window, double x, double y) {
            onMouseMove(new MouseState(toPoint(x, y), true));
        }
    };

    public GlfwMouseInput(IMouseListener listener) {
        this.listener = listener;
    }

    private Point toPoint(double x, double y) {
        return new Point(
            (int) x,
            (int) y
            );
    }

    @Override
    public void bind(IFrame frame) {
        if (frame instanceof WindowFrame) {
            ((WindowFrame)frame).bind(this);
        }
    }

    public void bind(long window) {
        cursorPosCallback.set(window);
    }

    @Override
    public void onMouseMove(MouseState mouse) {
        listener.onMouseMove(mouse);
    }

    @Override
    public void onMouseClick(MouseState mouse) {
        listener.onMouseClick(mouse);
    }

    @Override
    public void unbind() {
        cursorPosCallback.set(0);
    }
}