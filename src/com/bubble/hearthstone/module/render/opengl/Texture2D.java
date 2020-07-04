package com.bubble.hearthstone.module.render.opengl;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public class Texture2D extends Texture {

    private final int width;
    private final int height;
    private final ByteBuffer data;

    // TODO : get width and ...
    public Texture2D(int id) {
        super(id);
        width = 0;
        height = 0;
        data = null;
    }

    public Texture2D(int width, int height, ByteBuffer data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }
    
    @Override
    public void bind() {
        bind(GL11.GL_TEXTURE_2D);
    }

    @Override
    public void unbind() {
        unbind(GL11.GL_TEXTURE_2D);
    }

    @Override
    public void upload() {
        bind();
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, data);
        GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D);
    }
}