package com.bubble.hearthstone.module.render.glfw;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.stl.Dimension;

import org.lwjgl.glfw.GLFW;

public class WindowManager implements IFramework {
    
    private WindowFrame frame;

    @Override
    public void start() {
        GLFW.glfwInit();
        run();
    }

    private void run() {
        createWindow();
        while (!frame.checkForClose()) {
            update();
        }
    }

    public void createWindow() {
        frame = new WindowFrame();
    }

    @Override
    public void stop() {
        GLFW.glfwTerminate();
    }

    private void update() {
        frame.refresh();
    }

    public void setWindowSize(Dimension size) {
        frame.setSize(size);
    }

    public IFrame getFrame() {
        return frame;
    }
}