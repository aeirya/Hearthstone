package com.bubble.hearthstone.module.render.opengl;

import org.lwjgl.opengl.GL11;

public abstract class Texture {
    protected final int id;

    public Texture() {
        id = GL11.glGenTextures();
    }

    protected Texture(int id) {
        this.id = id;
    }

    public void destroy() {
        GL11.glDeleteTextures(id);
    }

    public abstract void bind();
    public abstract void unbind();
    public abstract void upload();

    protected void bind(int target) {
        GL11.glBindTexture(target, id);
    }
    
    protected void unbind(int target) {
        GL11.glBindTexture(target, 0);
    }

    // TODO: move to texture manager

    public enum TextureType {
        TEXTURE_2D, TEXTURE_ARRAY
    }
}