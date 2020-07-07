package com.bubble.hearthstone.module.render.opengl;

import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.List;

import com.bubble.hearthstone.stl.Point;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class FontRenderer {

    private final Shader shader;
    private static final String SHADER_PATH = "/Users/madscientist/Desktop/Documents/AP/Hearthstone copy 2/data/asset/shader/";
    private boolean immediateMode;
    
    private VertexBufferBuilder<FontRenderer.Vertex> vbb = new VertexBufferBuilder<>();

    public FontRenderer(boolean immediateMode) {
        this.immediateMode = immediateMode;
        shader = new Shader(SHADER_PATH + "text");
    }

    public void renderText(TextMessage text, Vector3f position, Vector3f rotation) {
        
        for (char c : text.getChars()) {

        }
        
    }

    public void setImmediateMode(boolean mode) {
        this.immediateMode = mode;
    }

    public void renderText(TextMessage text, Point position) {
        //
        renderText(text, position);
    }

    private void renderChar(char c, Vector3f position, Vector3f direction, Vector4f color, float scale) {
        final int col = c & 15;
        final int row = c >> 4;
        final float d = 1.0f / 16.0f;
        vbb.begin();
        addVertex(vbb, position, color,  new Vector2f(col * d , row * d) );
        addVertex(vbb, position.add(new Vector3f(direction.x, 0, direction.z)), color,  new Vector2f((col + 1) * d , row * d));
        addVertex(vbb, position.add(new Vector3f(0, direction.y, direction.z)), color,  new Vector2f(col * d , (row + 1) * d));
        addVertex(vbb, position.add(direction.mul(scale)), color,  new Vector2f((col + 1) * d , (row + 1) * d) );
        vbb.end();
    }

    private void addVertex(VertexBufferBuilder<FontRenderer.Vertex> vbb, Vector3f pos, Vector4f color, Vector2f uv) {
        vbb.addVertex(new FontRenderer.Vertex(pos, color, uv));
    }

    private static class Vertex implements IVertex {

        private final Vector3f pos;
        private final Vector4f color;
        private final Vector2f uv;

        public Vertex(Vector3f pos, Vector4f color, Vector2f uv) {
            this.pos = pos;
            this.color = color;
            this.uv = uv;
        }

        @Override
        public int getSize() {
            return 9;
        }

        @Override
        public List<VertexAttribute> getAttributes() {
            return Arrays.asList(
                new VertexAttribute(0,3,0), 
                new VertexAttribute(1,4,3), 
                new VertexAttribute(2,2,7) 
            );
        }

        @Override
        public void append(FloatBuffer vertexBuffer) {
            // TODO Auto-generated method stub

        }

    }
}