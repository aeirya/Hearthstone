package com.bubble.hearthstone.module.gui.events;

import com.bubble.hearthstone.module.event.Event;
import com.bubble.hearthstone.module.event.EventType;

public abstract class GuiEvent extends Event implements IGuiEvent {

    public GuiEvent(EventType type) {
        super(type);
    }
}