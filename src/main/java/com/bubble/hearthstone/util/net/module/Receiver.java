package com.bubble.hearthstone.util.net.module;

import java.util.LinkedList;

public class Receiver implements IReceiver {

    private final INetworkConnection connection;
    private LinkedList<IResponse> list;

    public Receiver(INetworkConnection connection) {
        this.connection = connection;
        list = new LinkedList<>();
    }

    public void run() {
        new Thread(
            () -> {
                while (true) {
                    final IResponse response = receive();
                    if (response == null) {
                        sleep();
                    }
                    else queue(response);
                }
            });
    }

    private void sleep() {
        final int sleepTime = 2;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void queue(IResponse response) {
        list.add(response);
    }

    private IResponse receive() {
        return connection.get();
    }

    @Override
    public IResponse getNext() {
        synchronized(this) {
            return list.removeFirst();
        }
    }
}