package com.bubble.hearthstone.module.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventBus {
    private final IEventDispatcher sender;
    private final List<IEventHandler> receivers;

    // private final IEventHandler sender;
    // private final List<IEventDispatcher> receivers;

    public EventBus(IEventDispatcher sender) {
        this.sender = sender;
        receivers = new ArrayList<>();
    }

    public void addReceiver(IEventHandler... handlers) {
        Arrays.asList(handlers).forEach(
            handler -> {
                registerListener(handler);
                // potential code: handler.setDispatcher
            }
        );
    }

    private void registerListener(IEventHandler handler) {
        receivers.add(handler);
    }

    public void broadcast(IEvent event) {
        receivers.forEach(r -> r.handle(event));
    }

    public void receive(IEvent event) {
        sender.dispatch(event);
    }
}