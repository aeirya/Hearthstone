package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class VertexBuffer {
    private final int vbo;
    private final int ebo;

    private final int vao;
    
    private int indexCount;
    
    public VertexBuffer() {
        vbo = GL15.glGenBuffers();
        ebo = GL15.glGenBuffers();
        vao = GL30.glGenVertexArrays();
    }

public <T extends IVertex> void upload(VertexBufferBuilder<T> vbb) {
        bind();
        indexCount = vbb.getIndexCount();

        final FloatBuffer vertices = vbb.geVertices().flip();
        final IntBuffer indices = vbb.getIndices().flip();

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices , GL15.GL_STATIC_DRAW);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, GL15.GL_STATIC_DRAW);   
        
        for (VertexAttribute attr : vbb.getVertexAttributes()) {
            attr.enable();
        }

        unbind();
    }
    
    public void bind() {
        GL30.glBindVertexArray(vao);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ebo);
    }

    public void draw() {
        GL11.glDrawElements(GL11.GL_TRIANGLES, indexCount, GL11.GL_UNSIGNED_INT, 0);
    }

    public void unbind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0); 
        GL30.glBindVertexArray(0);
    }

    public void destroy() {
        GL15.glDeleteBuffers(vbo);
        GL30.glDeleteVertexArrays(vao);
    }
}