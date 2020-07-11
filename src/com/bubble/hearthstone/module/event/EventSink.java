package com.bubble.hearthstone.module.event;

import java.util.ArrayList;
import java.util.List;

public class EventSink {
    private final IEventHandler receiver;
    private final List<IEventDispatcher> dispatchers;

    public EventSink(IEventHandler receiver) {
        this.receiver = receiver;
        dispatchers = new ArrayList<>();
    }

    public void hook(IEventDispatcher dispatcher) {
        dispatchers.add(dispatcher);
    }

    public void remove(IEventDispatcher dispatcher) {
        dispatchers.remove(dispatcher);
    }

    public void dispatch(IEvent event) {
        dispatchers.forEach(dis -> dis.dispatch(event));
    }    

    public void receive(IEvent event) {
        receiver.handle(event);
    }
}