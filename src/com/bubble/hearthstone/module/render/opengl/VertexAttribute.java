package com.bubble.hearthstone.module.render.opengl;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryUtil;

public class VertexAttribute {
    private final int location;
    private final int size;
    private final int stride;
    
    public VertexAttribute(int location, int size, int stride) {
        this.location = location;
        this.size = size;
        this.stride = stride;
    }

    public void enable() {
        GL20.glVertexAttribPointer(location, size, GL11.GL_FLOAT, false, stride * (4), MemoryUtil.NULL);
        GL20.glEnableVertexAttribArray(location);
    }

    public void disable() {
        GL20.glDisableVertexAttribArray(location);
    }
}