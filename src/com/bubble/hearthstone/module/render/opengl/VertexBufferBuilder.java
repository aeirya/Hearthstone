package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.system.MemoryUtil;

public class VertexBufferBuilder {

    private final FloatBuffer vertices;
    private final IntBuffer indices;

    public VertexBufferBuilder() {
        final int BUFFER_SIZE = 0x4000;
        vertices = MemoryUtil.memAllocFloat(BUFFER_SIZE);
        indices = MemoryUtil.memAllocInt(BUFFER_SIZE * 3 / 2);
    }

    public int[] getIndices() {
        return null;
    } 

    public int[] geVertices() {
        return null;
    }
}