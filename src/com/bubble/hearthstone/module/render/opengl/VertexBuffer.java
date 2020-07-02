package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class VertexBuffer {
    private final int vbo;
    private final int ebo;

    private final int vao;

    public VertexBuffer() {
        vbo = GL15.glGenBuffers();
        ebo = GL15.glGenBuffers();
        vao = GL30.glGenVertexArrays();
    }

    public void upload(VertexBufferBuilder vbb) {
        upload(vbb.geVertices(), vbb.getIndices());
    }

    public void upload(FloatBuffer vertices, IntBuffer indices) {
        GL30.glBindVertexArray(vao);

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);

        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ebo);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, GL15.GL_STATIC_DRAW);
        
        // GL20.glVertexAttribPointer

        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
    }
    
    public void destroy() {
        GL15.glDeleteBuffers(vbo);
        GL30.glDeleteVertexArrays(vao);
    }
}