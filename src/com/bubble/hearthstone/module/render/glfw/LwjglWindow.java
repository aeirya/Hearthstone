package com.bubble.hearthstone.module.render.glfw;

import java.nio.IntBuffer;

import com.bubble.hearthstone.module.gui.components.IFrame;
import com.bubble.hearthstone.stl.Dimension;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class LwjglWindow implements IFrame {

    private final long window;

    public LwjglWindow() {
        this.window = createWindow();
    }

    private long createWindow() {
        final long w = createWindow(new Dimension(100, 100), "Window");
        GLFW.glfwMakeContextCurrent(w);
        GL.createCapabilities();
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        return w;
    }

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
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }
}