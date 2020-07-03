package com.bubble.hearthstone.module.gui.events;

import com.bubble.hearthstone.module.event.EventType;
import com.bubble.hearthstone.module.event.IEventHandler;
import com.bubble.hearthstone.module.gui.IGuiEventHandler;

public class LaunchEvent extends GuiEvent {

    public LaunchEvent() {
        super(EventType.LAUNCH);
    }

    @Override
    public void process(IEventHandler handler) {
        System.out.println("B");
        handler.handle(this);
    }

    @Override
    public void process(IGuiEventHandler handler) {
        System.out.println("C");
    }

}