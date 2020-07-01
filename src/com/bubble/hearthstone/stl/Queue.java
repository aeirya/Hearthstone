package com.bubble.hearthstone.stl;

import java.util.LinkedList;

public class Queue<T> {

    private final LinkedList<T> items;

    public Queue() {
        items = new LinkedList<>();
    }

    public void push(T event) {
        items.add(event);
    }

    public T next() {
        return items.removeFirst();
    }

    public boolean hasNext() {
        return ! items.isEmpty();
    }
}