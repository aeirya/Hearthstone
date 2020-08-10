package com.bubble.net.client.service;

import java.util.LinkedList;

class LockedQueue {
    private final Object lock = new Object();
    private final LinkedList<String> items;

    LockedQueue() {
        items = new LinkedList<>();
    }

    void push(String item) {
        items.add(item);
        synchronized(lock) {
            lock.notifyAll();
        }
    }

    String getNext() {
        synchronized (lock) {
            while (items.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return items.removeFirst();
    }
}