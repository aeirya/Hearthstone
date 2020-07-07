package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.List;

public class Vertex implements IVertex {
    public final float x;
    public final float y;
    public final float z;

    public Vertex(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public List<VertexAttribute> getAttributes() {
        return Arrays.asList(new VertexAttribute(0, 3, 0));
    }

    @Override
    public void append(FloatBuffer vertexBuffer) {
        vertexBuffer.put(x);
        vertexBuffer.put(y);
        vertexBuffer.put(z);
    }
}