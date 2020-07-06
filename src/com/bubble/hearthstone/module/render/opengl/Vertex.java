package com.bubble.hearthstone.module.render.opengl;

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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<VertexAttribute> getAttributes() {
        // TODO Auto-generated method stub
        return null;
    }
}