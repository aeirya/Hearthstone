package com.bubble.hearthstone.module.render.opengl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class TextureCreator {

    public List<Texture> createTextures2D(int n) {
        final int[] buffer = new int[n];
        GL11.glGenTextures(buffer);
        final List<Texture> result = new ArrayList<>();
        for (int texture : buffer) {
            result.add(
                new Texture2D(texture)
            );
        }
        return result;
    }
}