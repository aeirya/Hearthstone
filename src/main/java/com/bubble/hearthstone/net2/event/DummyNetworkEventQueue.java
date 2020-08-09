package com.bubble.hearthstone.net2.event;

import com.bubble.hearthstone.net2.event.events.IdleEvent;

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

    public void push(IGameEvent event) {
        this.queue.push(event);
    }
}