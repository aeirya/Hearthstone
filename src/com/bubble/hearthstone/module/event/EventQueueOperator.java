package com.bubble.hearthstone.module.event;

public class EventQueueOperator {
    private final EventManager manager;
    private final Thread thread;

    public EventQueueOperator(EventManager manager) {
        this.manager = manager;
        thread = new Thread(this::loop);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    private void loop() {
        final int WAIT_TIME = 2;
        while (isAlive()) {
            final boolean result = operate();
            if (!result) {
                sleep(WAIT_TIME);
            }
        }
    }

    private boolean isAlive() {
        return ! thread.isInterrupted();
    }

    private void sleep(int waitTime) {
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean operate() {
        final IEvent event = getNext();
        if (event == null) {
            return false;
        } else {
            process(getNext());
            return true;
        }
    }

    private void process(IEvent event) {
        manager.handle(event);
    }

    private IEvent getNext() {
        return manager.nextEvent();
    }
}