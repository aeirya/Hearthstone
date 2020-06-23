package com.bubble.hearthstone.net.event;

import com.bubble.hearthstone.util.services.ServiceLocator;

public class EventHandler {
    private final EventQueue queue;
    protected final IEventProcessor processor;
    private static final int WAIT_TIME = 10;

    public EventHandler(IEventProcessor processor) {
        this.queue = new EventQueue();
        this.processor = processor;
    }

    public EventHandler start() {
        new Thread(
            () -> {
                synchronized (this) {
                    while (true) {
                        loop();
                        try {
                            wait(WAIT_TIME);
                        } catch (InterruptedException e) {
                            ServiceLocator.getLogger().error(this, e);
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        ).start();
        return this;
    }

    private void loop() {
        if (queue.isFree()) goIdle();
        else {
            process(getNext());
        }
    }

    private IGameEvent getNext() {
        return queue.next();
    }

    protected void process(IGameEvent event) {
        event.process(processor);
    }

    private void goIdle() {
        // do nothing
    }

    public void receive(IGameEvent event) {
        queue.push(event);
    }
}

//concurrent queue