package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.module.render.opengl.VertexBuffer;

public class CardRenderer {
    private final VertexBuffer buffer;
    
    public CardRenderer(VertexBuffer buffer) {
        this.buffer = buffer;
    }
}