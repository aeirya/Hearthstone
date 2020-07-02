package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryUtil;

public class VertexBufferBuilder {

    private final FloatBuffer vertices;
    private final IntBuffer indices;
    private final List<VertexAttribute> vertexAttributes;

    public VertexBufferBuilder() {
        vertexAttributes = new ArrayList<>();
        final int BUFFER_SIZE = 0x4000;
        vertices = MemoryUtil.memAllocFloat(BUFFER_SIZE);
        indices = MemoryUtil.memAllocInt(BUFFER_SIZE * 3 / 2);
    }

    public List<VertexAttribute> getVertexAttributes() {
        return vertexAttributes;
    }

    // ahhhhhhhh

    public IntBuffer getIndices() {
        return indices;
    } 

    public FloatBuffer geVertices() {
        return vertices;
    }

    public int getVertexCount() {
        // TODO
        return 0;
    }
}