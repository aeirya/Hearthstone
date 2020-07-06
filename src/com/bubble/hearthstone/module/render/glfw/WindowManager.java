package com.bubble.hearthstone.module.render.glfw;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.stl.Dimension;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public class WindowManager implements IFramework {
    
    private WindowFrame frame;

    @Override
    public void start() {
        GLFW.glfwInit();
        macOsSupportTweak();
        createWindow();
    }

    private void macOsSupportTweak() {
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 4);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 1);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);
    }

    private void run() {
        if (!frame.checkForClose()) {
            frame.refresh();
        } else {
            // EventSystem.dispatch(
            //     //quit event
            //     null
            // );
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