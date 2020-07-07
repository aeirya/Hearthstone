package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;

import org.lwjgl.system.MemoryUtil;

public class VertexBufferBuilder <T extends IVertex> {

    private FloatBuffer vertices;
    private IntBuffer indices;
    private T firstVertex = null;
    private int beginingIndex = -1;
    private int vertexCount = 0;
    private int indexCount = 0;

    public VertexBufferBuilder() {
        final int BUFFER_SIZE = 0x4000;
        vertices = MemoryUtil.memAllocFloat(BUFFER_SIZE);
        indices = MemoryUtil.memAllocInt(BUFFER_SIZE * 3 / 2);
    }

    public List<VertexAttribute> getVertexAttributes() {
        return firstVertex.getAttributes();
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

    public int getIndexCount() {
        return indexCount;
    }

    public void begin() {
        beginingIndex = getVertexCount();
    }

    public void addVertex(T vertex) {
        if (firstVertex == null) {
            firstVertex = vertex;
        }
        vertex.append(vertices);
        vertexCount++;
        if (vertexCount * vertex.getSize() > 0.8 * vertices.capacity()) {
            FloatBuffer f = MemoryUtil.memAllocFloat((int)(1.2 * vertices.capacity()));
            f.put(vertices.array(), 0, vertexCount * vertex.getSize());
            vertices = f;
        }
    }

    public void addTriangle(int a, int b, int c) {
        indices.put(a + beginingIndex);
        indices.put(b + beginingIndex);
        indices.put(c + beginingIndex);
        indexCount += 3;
        if (indexCount > 0.8 * indices.capacity()) {
            IntBuffer f = MemoryUtil.memAllocInt((int)(1.2 * indices.capacity()));
            f.put(indices.array(), 0, vertexCount);
            indices = f;
        }
    }

    public boolean isEmpty() {
        return vertexCount == 0;
    }

    public void clear() {
        vertices.flip();
        indices.flip();
        vertexCount = 0;
        indexCount = 0;
    }

    public void end() {
        beginingIndex = -1;    
    }
}