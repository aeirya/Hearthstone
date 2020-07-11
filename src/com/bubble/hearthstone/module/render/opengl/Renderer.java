package com.bubble.hearthstone.module.render.opengl;

import java.util.Arrays;
import java.util.List;

import com.bubble.hearthstone.module.gui.components.IComponent;
import com.bubble.hearthstone.module.gui.components.Panel;
import com.bubble.hearthstone.module.render.GuiElement;
import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.module.render.GuiElement.GuiElementType;
import com.bubble.hearthstone.module.service.ServiceLocator;

import org.lwjgl.opengl.GL11;

public class Renderer implements IRenderer {

    private VertexBuffer buffer;
    private Shader shader;

    public Renderer() {
        //
    }

    @Override
    public void render(IComponent component) {
        // TODO Auto-generated method stub
        //
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
        shader = new Shader(getShaderFolder() + "default");
        rebuild();
    }

    private String getShaderFolder() {
        return ServiceLocator.getResources().getResourceConfig().getShadersFolder();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    public void update () {
        renderTest();
    }

    private List<GuiElement> getElements() {
        return Arrays.asList(
            new Panel().toGuiElement()
        );
    }

    private void drawElements(Graphics g) {
        getElements().forEach(
            e -> render(g, e)
        );
    }

    private void render(Graphics g, GuiElement e) {
        switch(e.type) {
            case PANEL:
            drawPanel(g, e);
            break;
            default:
            return;
        }
    }

    private void drawPanel(Graphics g, GuiElement e) {
        g.drawRect(e.location.x, e.location.y, e.size.width, e.size.height);
    }

    private void rebuild() {
        // VertexBufferBuilder<Vertex> vbb = new VertexBufferBuilder<>();
        Graphics g = new Graphics();
        g.drawRect(-0.5f, -0.5f, 1.0f, 1.0f);
        g.drawRect(-0.25f + 1.0f, -0.25f, 0.5f, 0.5f);
        // g.drawTriangle(-0.5f, -0.5f, 1.0f);
        // g.drawLine(-0.5f, 0.0f, -0.5f, 0.0f);
        // g.drawHorizontalLine(-0.5f, 0.0f, -0.5f, 0.01f);
        // TODO: iterate and render components
        buffer.upload(g.getVBB());
    }
}