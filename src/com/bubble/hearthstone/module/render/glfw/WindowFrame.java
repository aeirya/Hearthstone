package com.bubble.hearthstone.module.render.glfw;

import java.nio.IntBuffer;

import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.module.input.keyboard.glfw.GlfwKeyboardInput;
import com.bubble.hearthstone.module.input.mouse.glfw.GlfwMouseInput;
import com.bubble.hearthstone.stl.Dimension;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class WindowFrame implements IFrame {

    private final long window;

    public WindowFrame() {
        this.window = createWindow();
    }

    private long createWindow() {
        final long w = createWindow(new Dimension(100, 100), "Window");
        GLFW.glfwMakeContextCurrent(w);
        GL.createCapabilities();
        // GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GL11.glClearDepth(1.0f);
        return w;
    }
    
    // private void setWindowColor(Color color) {
    //     //
    // }

    private long createWindow(Dimension size, String title) {
        return GLFW.glfwCreateWindow(size.width, size.height, title, MemoryUtil.NULL, MemoryUtil.NULL);
    }

    @Override
    public void setTitle(String title) {
        GLFW.glfwSetWindowTitle(window, title);
    }

    @Override
    public void setSize(Dimension size) {
        GLFW.glfwSetWindowSize(window, size.width, size.height);
    }

    @Override
    public Dimension getSize() {
        final IntBuffer w = BufferUtils.createIntBuffer(1);
        final IntBuffer h = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetWindowSize(window, w, h);
        final int width = w.get(0);
        final int height = h.get(0);
        return new Dimension(width, height);
    }

    @Override
    public boolean checkForClose() {
        return GLFW.glfwWindowShouldClose(window);
    }

    // ?
    public void refresh() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public void bind(GlfwMouseInput input) {
        input.bind(window);
    }

    public void bind(GlfwKeyboardInput input) {
        input.bind(window);
    }
}