package com.bubble.hearthstone.module.gui.events;

import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventHandler;
import com.bubble.hearthstone.module.gui.IGuiEventHandler;

public interface IGuiEvent extends IEvent {
    default void process(IEventHandler handler) {
        handler.handle(this);
    }

    void process(IGuiEventHandler handler);
}