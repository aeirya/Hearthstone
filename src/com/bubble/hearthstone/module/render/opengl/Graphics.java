package com.bubble.hearthstone.module.render.opengl;

import com.bubble.hearthstone.stl.Color;

public class Graphics implements IGraphics {

    private final VertexBufferBuilder<Vertex> vbb;
    private Color color;

    public Graphics() {
        vbb = new VertexBufferBuilder<>();
        color = new Color(0,0,0);
    }
    
    public VertexBufferBuilder<Vertex> getVBB() {
        return vbb;
    }

    public void drawText(String text, float x, float y, int fontSize) {
        //
    }

    public void drawRect(float x, float y, float w, float h) {
        vbb.begin();
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addVertex(new Vertex(x + w, y, 0.0f));
        vbb.addVertex(new Vertex(x, y + h, 0.0f));
        vbb.addVertex(new Vertex(x + w, y + h, 0.0f));
        vbb.addTriangle(0, 1, 2);
        vbb.addTriangle(2, 1, 3);
        vbb.end();
    }

    //
    public void drawTriangle(float x, float y, float a) {
        vbb.begin();
        vbb.addVertex(new Vertex(x, y, 0.0f));
        vbb.addVertex(new Vertex(x+a, y, 0.0f));
        vbb.addVertex(new Vertex(x, y+a, 0.0f));
        vbb.addTriangle(0, 1, 2);
        vbb.end();
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        vbb.begin();
        vbb.addVertex(new Vertex(x1, y1, 0.0f));
        vbb.addVertex(new Vertex(x2, y2, 0.0f));
        vbb.addTriangle(0, 1, 1);
        vbb.end();
    }

    public void drawHorizontalLine(float x1, float x2, float y, float width) {
        drawRect(x1,y, x2-x1, width);
    }

    public void setPenColor(Color color) {
        this.color = color;
        // do sth about the shader color
    }
}