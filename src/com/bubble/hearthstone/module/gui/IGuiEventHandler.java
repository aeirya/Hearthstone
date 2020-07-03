package com.bubble.hearthstone.module.gui;

import com.bubble.hearthstone.module.event.IEventHandler;
import com.bubble.hearthstone.module.gui.events.IGuiEvent;

public interface IGuiEventHandler extends IEventHandler {
    void handle(IGuiEvent event);
}