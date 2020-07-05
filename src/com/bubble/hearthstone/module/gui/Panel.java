package com.bubble.hearthstone.module.gui;

import com.bubble.hearthstone.module.graphics.IGraphics;
import com.bubble.hearthstone.module.graphics.menu.IMenu;

public abstract class Panel implements IMenu {

    protected final SceneLayout layout;
    
    public Panel() {
        layout = new SceneLayout();
    }

    @Override
    public void launch(IGraphics graphics) {
        onLaunch();
        graphics.load(this);
    }

    protected void onLaunch() {
        // default : do nothing
    }
}