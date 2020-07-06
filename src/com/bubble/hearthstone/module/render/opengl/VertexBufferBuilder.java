package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryUtil;

public class VertexBufferBuilder <T extends IVertex> {

    private FloatBuffer vertices;
    private IntBuffer indices;

    private final List<VertexAttribute> vertexAttributes;
    private int beginingIndex = -1;
    private int vertexCount = 0;

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
        return vertexCount;
    }

    public void begin() {
        beginingIndex = getVertexCount();
    }

    public void addVertex(float vertex) {
        vertices.put(vertex);
        vertexCount++;
        if (vertexCount > 0.8 * vertices.capacity()) {
            FloatBuffer f = MemoryUtil.memAllocFloat((int)(1.2 * vertices.capacity()));
            f.put(vertices.array());
            vertices = f;
        }
    }

    // public void addVertex(T vertex) {
    //     //
    // }

    // public void append() {}

    public void end() {
        beginingIndex = -1;    
    }
}