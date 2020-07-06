package com.bubble.hearthstone.module.render.opengl;

import com.bubble.hearthstone.module.gui.components.IComponent;
import com.bubble.hearthstone.module.render.IRenderer;

import org.lwjgl.opengl.GL11;

public class Renderer implements IRenderer {

    private VertexBuffer buffer;
    private Shader shader;
    private static final String SHADER_PATH = "/Users/madscientist/Desktop/Documents/AP/Hearthstone copy 2/data/asset/shader/";

    public Renderer() {
        //
    }

    @Override
    public void render(IComponent component) {
        // TODO Auto-generated method stub

    }

    private void renderTest() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        shader.bind();
        buffer.bind();
        buffer.draw();
    }

    @Override
    public void start() {
        buffer = new VertexBuffer();
        shader = new Shader(SHADER_PATH + "default");
        rebuild();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    public void update () {
        renderTest();
    }

    private void rebuild() {
        // VertexBufferBuilder<Vertex> vbb = new VertexBufferBuilder<>();
        Graphics g = new Graphics();
        g.drawRect(-0.5f, -0.5f, 1.0f, 1.0f);
        // TODO: iterate and render components
        // g.getVBB().
        buffer.upload(g.getVBB());
    }
}