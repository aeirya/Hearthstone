package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.net.event.events.IdleEvent;

public class DummyNetworkEventQueue implements INetworkEventQueue {

    private final EventQueue queue;

    public DummyNetworkEventQueue() {
        this.queue = new EventQueue();
    }

    public IGameEvent get() {
        if (!queue.isFree()) {
            return queue.next();
        } else {
            return new IdleEvent();
        }
    }

    public boolean hasNext() {
        return ! queue.isFree();
    }

    public void push(IGameEvent event) {
        this.queue.push(event);
    }
}