package com.bubble.hearthstone.module.render.opengl;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class VertexBuffer {
    private final int vbo;
    private final int ebo;

    private final int vao;
    
    private int vertexCount;
    
    public VertexBuffer() {
        vbo = GL15.glGenBuffers();
        ebo = GL15.glGenBuffers();
        vao = GL30.glGenVertexArrays();
    }

    public void upload(VertexBufferBuilder vbb) {
        bind();
        vertexCount = vbb.getVertexCount();

        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vbb.geVertices(), GL15.GL_STATIC_DRAW);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, vbb.getIndices(), GL15.GL_STATIC_DRAW);   
        
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
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);
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