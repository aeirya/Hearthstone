package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.module.render.opengl.VertexBuffer;

public class ArenaRenderer {
    
    private final CardRenderer cardRenderer;
    private final HandRenderer handRenderer;
    private final VertexBuffer buffer;

    public ArenaRenderer() {
        buffer = new VertexBuffer();
        cardRenderer = new CardRenderer(buffer);
        handRenderer = new HandRenderer(cardRenderer, buffer);
    }

    private void renderBackground() {
        //
    }

    private void renderBattleboard() {
        //
    }

    private void renderHero() {
        //
    }

    private void renderHand() {
        //
    }

    private void renderOther() {
        //
    }
}