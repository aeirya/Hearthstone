package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.util.List;

public interface IVertex {
    int getSize();
    List<VertexAttribute> getAttributes();
    void append(FloatBuffer vertexBuffer);
}