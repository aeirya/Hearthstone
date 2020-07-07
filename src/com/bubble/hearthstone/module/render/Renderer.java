package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.module.gui.components.IComponent;
import com.bubble.hearthstone.module.render.GuiElement.GuiElementType;
import com.bubble.hearthstone.module.render.opengl.FontRenderer;

public class Renderer implements IRenderer {
    
    private final IRenderer gameRenderer;
    private final FontRenderer fontRenderer;
    private final GuiRenderer guiRenderer;

    public Renderer(GraphicsType graphicsType) {
        gameRenderer = initiateRenderer(graphicsType);
        fontRenderer = initiateFontRenderer();
        guiRenderer = null;
    }

    private IRenderer initiateRenderer(GraphicsType graphicsType) {
        if (graphicsType == GraphicsType.OPENGL) {
            return new com.bubble.hearthstone.module.render.opengl.Renderer();
        }
        return null;
    }

    private FontRenderer initiateFontRenderer() {
        return new FontRenderer(true);
    }

    public void render(IComponent component) {
        final GuiElement element = getElement(component);
        final IRenderer renderer = getRenderer(element.type);
        renderer.render(component);
        // gameRenderer.render(component);
    }

    private GuiElement getElement(IComponent component) {
        //
        return (GuiElement) component;
    }

    private IRenderer getRenderer(GuiElementType type) {
        switch(type) {
            case PANEL:
            return guiRenderer;
            default:
            return gameRenderer;
        }
    }

    @Override
    public void start() {
        gameRenderer.start();
        
    }

    @Override
    public void stop() {
        gameRenderer.stop();
    }

    @Override
    public void update() {
        gameRenderer.update();
    }
}