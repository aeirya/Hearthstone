package com.bubble.hearthstone.util.net.module;

public class Sender implements ISender {

    private final INetworkConnection connection;
    private final NumberGenerator generator;
    private IResponse response;
    private int id;

    public Sender(INetworkConnection connection) {
        this.connection = connection;
        generator = new NumberGenerator();
        response = null;
    }

    public IResponse send(IRequest request) {
        int n = nextNumber();
        request.setID(n);
        connection.push(request);
        waitForResponse();
        return response;
    }

    private void waitForResponse() {
        synchronized (this) {
            while (response == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public boolean checkResponse(IResponse response) {
        if (response.getID() == id) {
            this.response = response;
            synchronized(this) {
                this.notifyAll();
            }
            return true;
        }
        return false;
    }

    private int nextNumber() {
        return generator.next();
    }

    private class NumberGenerator {
        private static final int STACK_LENGTH = 32;
        private int last;

        NumberGenerator() {
            last = -1;
        }

        int next() {
            final int next = (last + 1) % STACK_LENGTH;
            last = next;
            return last;
        }
    }
}