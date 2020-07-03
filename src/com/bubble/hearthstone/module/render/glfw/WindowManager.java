package com.bubble.hearthstone.module.render.glfw;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.stl.Dimension;

import org.lwjgl.glfw.GLFW;

public class WindowManager implements IFramework {
    
    private WindowFrame frame;

    @Override
    public void start() {
        GLFW.glfwInit();
        createWindow();
    }

    private void run() {
        if (!frame.checkForClose()) {
            frame.refresh();
        } else {
            EventSystem.dispatch(
                //quit event
                null
            );
        }
    }

    private void createWindow() {
        frame = new WindowFrame();
    }

    @Override
    public void stop() {
        GLFW.glfwTerminate();
    }

    public void setWindowSize(Dimension size) {
        frame.setSize(size);
    }

    public IFrame getFrame() {
        return frame;
    }

    public void update() {
        run();
    }
}