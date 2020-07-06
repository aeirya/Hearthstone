package com.bubble.hearthstone.module.render.opengl;

public class Graphics implements IGraphics {

    private final VertexBufferBuilder<Vertex> vbb;

    public Graphics() {
        vbb = new VertexBufferBuilder<>();
    }

    // @Override
    // public void drawRect(int x, int y, int w, int h) {
    //     VertexBufferBuilder<Vertex> vbb = new VertexBufferBuilder<>();
    //     vbb.addVertex(new Vertex(0, 0,0));
    //     vbb.addVertex(new Vertex(x, 0,0));
    //     vbb.addVertex(new Vertex(0, 0,0));
    //     vbb.addVertex(vertex);
    //     vbb.addVertex(vertex);
    //     vbb.addVertex(vertex);
    // }
    
    public VertexBufferBuilder<Vertex> getVBB() {
        return vbb;
    }

    public void drawRect(float x, float y, float w, float h) {
        vbb.begin();
        vbb.addVertex(new Vertex(x, y, 0.5f));
        vbb.addVertex(new Vertex(x + w, y, 0.5f));
        vbb.addVertex(new Vertex(x, y + h, 0.5f));
        vbb.addVertex(new Vertex(x + w, y + h, 0.5f));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(2, 1, 3);
        vbb.end();
    }
}