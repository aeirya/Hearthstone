package com.bubble.hearthstone.net2.event;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class EventHandler {
    private final EventQueue queue;
    protected final GameManager manager;
    private static final int WAIT_TIME = 10;

    public EventHandler(GameManager manager) {
        this.queue = new EventQueue();
        this.manager = manager;
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
        event.process(manager);
    }

    private void goIdle() {
        // do nothing
    }

    public void receive(IGameEvent event) {
        queue.push(event);
    }
}

//concurrent queue