package com.bubble.hearthstone.module.render.opengl;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL30;

public class Texture2DArray extends Texture {

    private final int width;
    private final int height;
    private final ByteBuffer data;
    private final int layers;
    private final int target;

    public Texture2DArray(int width, int height, int layers, ByteBuffer data) {
        this.width = width;
        this.height = height;
        this.layers = layers;
        this.data = data;
        target = GL30.GL_TEXTURE_2D_ARRAY;
    }
    
    @Override
    public void bind() {
        bind(target);
    }

    @Override
    public void unbind() {
        unbind(target);
    }

    @Override
    public void upload() {
        bind();
        GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
        GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL12.glTexImage3D(target, 0, GL11.GL_RGBA, width, height, layers, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, data);
        GL30.glGenerateMipmap(target);
        // GL13.glActiveTexture();
    }
}