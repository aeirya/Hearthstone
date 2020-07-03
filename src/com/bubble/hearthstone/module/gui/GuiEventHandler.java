package com.bubble.hearthstone.module.gui;

import com.bubble.hearthstone.module.gui.events.IGuiEvent;

public class GuiEventHandler implements IGuiEventHandler {

    @Override
    public void handle(IGuiEvent event) {
        event.process(this);
    }
}