package com.bubble.hearthstone.module.render;

import com.bubble.hearthstone.module.gui.components.IComponent;
import com.bubble.hearthstone.module.render.opengl.IGraphics;

public abstract class Renderer implements IRenderer {
    
    public void render(IComponent component) {
        
    }

    public IGraphics getGraphics() {
        return null;
    }
}