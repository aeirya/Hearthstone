package com.bubble.hearthstone.module.render.opengl;

import com.bubble.hearthstone.service.gui.components.IComponent;
import com.bubble.hearthstone.message.IMessage;
import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.module.render.glfw.LwjglWindow;
import com.bubble.hearthstone.stl.Dimension;

import org.lwjgl.glfw.GLFW;

public class Renderer implements IRenderer {

    private LwjglWindow frame;

    public Renderer() {
        //
    }

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
        frame = new LwjglWindow();
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

    @Override
    public void handleMessage(Object message) {
        // do nothing
    }

    @Override
    public void handle(IMessage message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(IComponent component) {
        // TODO Auto-generated method stub

    }
}