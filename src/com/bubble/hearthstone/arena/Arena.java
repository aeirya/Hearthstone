package com.bubble.hearthstone.server.arena;

import com.bubble.hearthstone.client.service.event.IEvent;
import com.bubble.hearthstone.client.service.event.IEventHandler;
import com.bubble.hearthstone.message.IMessage;
import com.bubble.hearthstone.message.IMessageSender;

public class Arena implements IEventHandler {

    private final IMessageSender messageSender;

    public Arena() {
        this.messageSender = null;
    }

    // @Override
    // public void send(IMessage message) {
    //     messageSender.send(message);
    // }

    @Override
    public void handle(IEvent event) {
        event.process(this);
    }

    public void handle(IArenaEvent event) {
        event.process(this);
    }
}